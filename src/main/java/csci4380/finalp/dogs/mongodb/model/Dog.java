/**
 * 
 */
package csci4380.finalp.dogs.mongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Dogs")
public class Dog {
	@Id
	private String id;	
	private Integer petId;
	@Indexed(direction=IndexDirection.ASCENDING)
	private String name;
	private String type;
	private String ownerName;
	private String address;
	private Integer age;
//	private Date updatedOn;
	private Boolean isSpayed;
	public Dog() {
		super();
	}
	public Dog(Integer petId, String name, String type, String ownerName, String address, int age, boolean isSpayed) {
		super();
		this.petId = petId;
		this.name = name;
		this.type = type;
		this.ownerName = ownerName;
		this.address = address;
		this.age = age;
		this.isSpayed = isSpayed;
	}
	public String getId() {
		return id;
	}
	public Integer getPetId() {
		return petId;
	}
	
	public void setPetId(Integer petId) {
		this.petId = petId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType() {
		this.type = type;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnername(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public boolean getIsSpayed() {
		return isSpayed;
	}
	public void setIsSpayed() {
		this.isSpayed = isSpayed;
	}
}
