package fr.philae.busmapper.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="t_user")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)


public class User implements Serializable {

	
	private Integer id;
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private String adress;
	private byte[] imageByte;
	private String imageUrl;
	private String gender;
	private Integer age;
	private String userType;
	private String phoneNumber;
	private String stationFollow;
	private ArrayList<String> listNotif;

	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	@Id   
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	@Column(name="username")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	@Column (name="full_name")
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	@Column (name="image_byte")
	public byte[] getImageByte() {
		return imageByte;
	}
	public void setImageByte(byte[] imageByte) {
		this.imageByte = imageByte;
	}
	@Column (name="image_url")
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

	

	public String getStationFollow() {
		return stationFollow;
	}
	public void setStationFollow(String stationFollow) {
		this.stationFollow = stationFollow;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public ArrayList<String> getListNotif() {
		return listNotif;
	}
	public void setListNotif(ArrayList<String> listNotif) {
		this.listNotif = listNotif;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
   
}
