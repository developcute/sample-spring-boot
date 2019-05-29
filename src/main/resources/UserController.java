package com.axonytes.corporate.controller;

import com.axonytes.corporate.entity.User;
import com.axonytes.corporate.exception.EntityNotFoundException;
import com.axonytes.corporate.io.AddressDetail;
import com.axonytes.corporate.io.BaseResponse;
import com.axonytes.corporate.io.UserRequest;
import com.axonytes.corporate.io.UserResponse;
import com.axonytes.corporate.service.UserService;
import com.axonytes.corporate.util.ResponseStatusCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

/**
 * UserController used for
 * 1.updateUser with user details
 * 2.Get user by userId
 * @author user
 *
 */
@RestController
public class UserController extends BaseController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Update user with userId, User details.
     * @param userId
     * @param request UserRequest
     * @return status (SUCCESS or FAILURE).
     */
    @RequestMapping(value = "/user/{userId}/update", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private BaseResponse updateUser(@Valid @RequestBody UserRequest request, @PathVariable("userId") Long userId) {

        if(userId <= 0) {
            throw new IllegalArgumentException("Invalid userId value: " + userId);
        }
        userService.updateUser(userId, userId, request.getFirstName(), request.getLastName(),
                request.getAddressLine1(), request.getAddressLine2(), request.getCountry(), request.getState(),
                request.getCity(), request.getArea(), request.getPostalCode(), request.getGender(), request.getBirthDate(),
                request.getContactNumber(), request.getContactNumber1(), request.getBloodGroupId(), request.getBloodDonation());
        return success();
    }

    /**
     * Get user by userId.
     * @param userId
     * @return status (SUCCESS or FAILURE). If status will success, then response
     * contain User details
     */
    @RequestMapping(value = "/user/{userId}/get", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getUser(@PathVariable("userId") Long userId) {

        if(userId <= 0) {
            throw new IllegalArgumentException("Invalid userId value: " + userId);
        }
        User user = userService.getUser(userId, true);
        if (user == null) {
            throw new EntityNotFoundException("No user found");
        }
        return getUserDetail(user);
    }

    private UserResponse getUserDetail(User user) {

        UserResponse response = new UserResponse();
        response.setStatus(ResponseStatusCode.SUCCESS);
        response.setUserId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmailId(user.getEmail());
        response.setAddressDetail(setAddressDetail(user));
        response.setAddressDetail2(setAddressDetail(user));
        LocalDate dob = null;
        if(user.getDateOfBirth() != null) {
            dob = user.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        response.setBirthdate(dob);
        response.setGender(user.getGender());
        if (dob != null) {
            response.setAge(ageCalculation(dob));
        }
        response.setContactNumber(user.getContactNumber());
        response.setContactNumber1(user.getContactNumber1());
        response.setProfilePicLoc(user.getProfilePicture());
        response.setBloodGroupId(user.getBloodGroupId());
        if (user.getBloodGroup() != null) {
            response.setBloodGroupName(user.getBloodGroup().getName());
        }
        response.setBloodDonation(user.getBloodDonation());
        return response;
    }

    private AddressDetail setAddressDetail(User user) {
        AddressDetail detail = new AddressDetail();
        detail.setAddressLine1(user.getAddress1());
        detail.setAddressLine2(user.getAddress2());
        detail.setCountryId(user.getCountryId());
        if (user.getCountry() != null) {
            detail.setCountryName(user.getCountry().getName());
        }
        detail.setStateId(user.getStateId());
        if (user.getState() != null) {
            detail.setStateName(user.getState().getName());
        }
        detail.setCityId(user.getCityId());
        if (user.getCity() != null) {
            detail.setCityName(user.getCity().getName());
        }
        detail.setAreaId(user.getAreaId());
        if (user.getArea() != null) {
            detail.setAreaName(user.getArea().getName());
        }
        detail.setPostalCode(user.getPostalCode());
        return detail;
    }

    private Integer ageCalculation(LocalDate dob) {

        LocalDate today = LocalDate.now();
        Period p = Period.between(dob, today);
        return p.getYears();
    }
}
