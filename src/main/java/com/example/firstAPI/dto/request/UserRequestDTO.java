package com.example.firstAPI.dto.request;

import com.example.firstAPI.DEnum.ECity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserRequestDTO {
    @NotNull(message = "lastName must be not null")
    private String firstName;
    @NotEmpty(message = "lassName can not empty")
    private String lastName;
    private String email;
    private Integer age;
    @CitySubset(anyOf = {ECity.HCM, ECity.HANOI, ECity.DA_NANG})
    private ECity city;



    public UserRequestDTO(String firstName, String lastName, String email, Integer age, ECity city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.city = city;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public ECity getCity() {
        return city;
    }

    public void setCity(ECity city) {
        this.city = city;
    }
}
