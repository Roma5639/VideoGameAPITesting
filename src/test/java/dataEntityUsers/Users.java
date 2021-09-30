package dataEntityUsers;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Users{

	@JsonProperty("Users")
	private List<UsersItem> users;

	public void setUsers(List<UsersItem> users){
		this.users = users;
	}

	public List<UsersItem> getUsers(){
		return users;
	}
}