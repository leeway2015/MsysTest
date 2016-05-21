package models;

import javax.persistence.Entity;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;
@Entity
public class User extends Model {

	private String username;
	private String firstname;
	private String lastname;
	private String address;

	public User(){
		
	}
	public User(String un, String fn, String ln, String addr) {
		this.username = un;
		this.firstname = fn;
		this.lastname = ln;
		this.address = addr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	 public static Finder<String, User> find =
	            new Finder<String, User>(User.class);

	@Override
	public String toString() {
		return "User [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", address="
				+ address + "]";
	}
	
	public ObjectNode toJson() {
		ObjectNode node = Json.newObject();
		node.put("username", username);
		return node;
	
	}
	 
	
}
