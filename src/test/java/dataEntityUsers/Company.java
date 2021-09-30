package dataEntityUsers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({ "bs", "catchPhrase", "name" })

public class Company{

	@JsonProperty("bs")
	private String bs;

	@JsonProperty("catchPhrase")
	private String catchPhrase;

	@JsonProperty("name")
	private String name;

	public void setBs(String bs){
		this.bs = bs;
	}

	public String getBs(){
		return bs;
	}

	public void setCatchPhrase(String catchPhrase){
		this.catchPhrase = catchPhrase;
	}

	public String getCatchPhrase(){
		return catchPhrase;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
	public String toString() {
		return "Company{" +
				"bs='" + bs + '\'' +
				", catchPhrase='" + catchPhrase + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}