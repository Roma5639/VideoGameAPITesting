package dataEntity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VideogameResponse {

	@JsonProperty("VideogameResponse")
	private List<ResponseItem> response;

	public void setResponse(List<ResponseItem> response){
		this.response = response;
	}

	public List<ResponseItem> getResponse(){
		return response;
	}
}