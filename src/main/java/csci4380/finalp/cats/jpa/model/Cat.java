/**
 * 
 */
package csci4380.finalp.cats.jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author tom
 *
 */
@Entity(name="CAT")	
public class Cat
{
	@Id
	@GeneratedValue		
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer petId;
	private String name;
	private String type;
//	@Column(name="owner_name")
	private String ownerName;
	private String address;
	private Integer age;
	private Boolean isSpayed;
//	@Temporal(TemporalType.DATE)
//	private Date updatedOn;
	private String updatedOn;
	
	public Cat() { }

//	public CatEntity(String name, String type, String ownerName, String address, Integer age, Boolean isSpayed, String updatedOn) {
	public Cat(String name, String type, String ownerName, String address, Integer age, Boolean isSpayed, String updatedOn) {
		super();
		this.name = name;
		this.type = type;
		this.ownerName = ownerName;
		this.address = address;
		this.age = age;
		this.isSpayed = isSpayed;
		this.updatedOn = updatedOn;
	}
	
//	public CatEntity(Integer petId, String name, String type, String ownerName, String address, Integer age, Boolean isSpayed, String updatedOn) {
	public Cat(Integer petId, String name, String type, String ownerName, String address, Integer age, Boolean isSpayed, String updatedOn) {
		this(name, type, ownerName, address, age, isSpayed, updatedOn);
		this.petId = petId;
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
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getIsSpayed() {
		return isSpayed;
	}

	public void setIsSpayed(Boolean isSpayed) {
		this.isSpayed = isSpayed;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "PetEntity [petId=" + petId + ", name=" + name + ", type=" + type + ", ownerName=" + ownerName + ", address="
				+ address + ", age=" + age + ", isSpayed=" + isSpayed + ", updatedOn=" + updatedOn + "]";
	}	
}
