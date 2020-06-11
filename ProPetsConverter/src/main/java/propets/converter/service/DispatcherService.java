package propets.converter.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

public interface DispatcherService extends Source{
	

	String FOUND_SEARCH = "foundtosearch";
	
	@Output(OUTPUT)
	MessageChannel lostToSearch();
	@Output(FOUND_SEARCH)
	MessageChannel foundToSearch();

}
