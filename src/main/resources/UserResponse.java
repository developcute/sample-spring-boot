package com.axonytes.corporate.io;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by user on 19-Sep-16.
 */
public class UserResponse extends BaseResponse {

    private Long userId;
    private String firstName;
    private String lastName;
    private String emailId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "Asia/Kolkata")
    private LocalDate birthdate;
    private Character gender;
    private Integer age;
    private String contactNumber;
    private String contactNumber1;
    private String profilePicLoc;
    private Long bloodGroupId;
    private String bloodGroupName;
    private Boolean bloodDonation;
    AddressDetail addressDetail;
    AddressDetail addressDetail2;
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber1() {
        return contactNumber1;
    }

    public void setContactNumber1(String contactNumber1) {
        this.contactNumber1 = contactNumber1;
    }

    public String getProfilePicLoc() {
        return profilePicLoc;
    }

    public void setProfilePicLoc(String profilePicLoc) {
        this.profilePicLoc = profilePicLoc;
    }

    public Long getBloodGroupId() {
        return bloodGroupId;
    }

    public void setBloodGroupId(Long bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }

    public String getBloodGroupName() {
        return bloodGroupName;
    }

    public void setBloodGroupName(String bloodGroupName) {
        this.bloodGroupName = bloodGroupName;
    }

    public Boolean getBloodDonation() {
		return bloodDonation;
	}

	public void setBloodDonation(Boolean bloodDonation) {
		this.bloodDonation = bloodDonation;
	}

	public AddressDetail getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(AddressDetail addressDetail) {
        this.addressDetail = addressDetail;
    }

	public AddressDetail getAddressDetail2() {
		return addressDetail2;
	}

	public void setAddressDetail2(AddressDetail addressDetail2) {
		this.addressDetail2 = addressDetail2;
	}
}
