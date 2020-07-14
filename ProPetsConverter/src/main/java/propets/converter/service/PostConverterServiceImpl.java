package propets.converter.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import propets.converter.dto.EntityDto;
import propets.converter.dto.LocationDto;
import propets.converter.dto.LocationEntityDto;
import propets.converter.dto.PostDto;

@EnableBinding(DispatcherService.class)
public class PostConverterServiceImpl implements PostConverterService{
	@Autowired
	DispatcherService dispatcherService;
	

	@Override
	public void sendData(PostDto postDto) {
		EntityDto entityDto = converter(postDto);
		if (entityDto.isTypePost()) {
			dispatcherService.foundToSearch().send(MessageBuilder.withPayload(entityDto).build());
		} 
		if (!entityDto.isTypePost()) {			
			dispatcherService.output().send(MessageBuilder.withPayload(entityDto).build());
		} 		
	}
	
	public EntityDto converter(PostDto postDto) {		
		return EntityDto.builder()
				.id(postDto.getId())
				.userLogin(postDto.getUserLogin())
				.typePost(postDto.isTypePost())
				.type(postDto.getType())
				.sex(postDto.getSex())
				.breed(postDto.getBreed())
				.location(locationToLocationEntityDto(postDto.getLocation()))
				.tags(tagsToString(postDto.getTags()))
				.build();
	}

	private String tagsToString(List<String> tags) {
		String delimeter = " ";		
		return tags.stream().collect(Collectors.joining(delimeter));
	}

	private LocationEntityDto locationToLocationEntityDto(LocationDto location) {		
		return LocationEntityDto.builder()
				.lat(location.getLatitude())
				.lon(location.getLongitude())
				.build();
	}
}
