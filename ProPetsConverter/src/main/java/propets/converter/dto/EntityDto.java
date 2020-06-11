package propets.converter.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntityDto {
	
	String id;
	boolean typePost;
	String userLogin;
	String type;
	String sex;
	String breed;
	@Singular
	List<String> tags;
    LocationDto location;

}
