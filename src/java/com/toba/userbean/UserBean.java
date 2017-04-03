package com.toba.userbean;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
   
@Entity
public class UserBean implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String stateCode;
    private String zipCode;
    private String email;
    private String userName;
    private String password;


    public UserBean (String firstName, String lastName, String phone, String address,
            String city, String state, String zipcode, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.stateCode = state;
        this.zipCode = zipcode;
        this.email = email;
        this.userName = lastName + zipcode;
        this.password = "welcome1";
    }

    public UserBean() {
        firstName = "";
        lastName = "";
        phone = "";
        address = "";
        city = "";
        stateCode = "";
        zipCode = "";
        email = "";
        userName = "";
        password = "";
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
      
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
        
    public String getAddress() {
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String getState() {
        return stateCode;
    }
    public void setState(String state){
        this.stateCode = state;
    }
    
    public String getZipcode() {
        return zipCode;
    }
    public void setZipcode(String zipcode){
        this.city = zipcode;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getUsername() {
        return userName;
    }
    public void setUsername(String username){
        this.userName = username;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }


    
    
}

