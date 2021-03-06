package propets.converter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	String tags;
    LocationEntityDto location;

}
