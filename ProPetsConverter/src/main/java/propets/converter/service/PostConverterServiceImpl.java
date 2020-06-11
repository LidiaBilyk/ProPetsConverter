package propets.converter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import propets.converter.dto.EntityDto;
import propets.converter.dto.PostDto;

@EnableBinding(DispatcherService.class)
public class PostConverterServiceImpl implements PostConverterService{
	@Autowired
	DispatcherService dispatcherService;
	
	ObjectMapper mapper = new ObjectMapper();

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
				.location(postDto.getLocation())
				.tags(postDto.getTags())
				.build();
	}
}
