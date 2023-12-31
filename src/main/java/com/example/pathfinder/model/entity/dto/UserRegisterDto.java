package com.example.pathfinder.model.entity.dto;

import com.example.pathfinder.model.entity.validation.FieldMatch;
import com.example.pathfinder.model.entity.validation.UniqueEmail;
import com.example.pathfinder.model.entity.validation.UniqueUsername;
import jakarta.validation.constraints.*;
@FieldMatch(first = "password",second = "confirmPassword",message = "Passwords should match.")
public class UserRegisterDto {

    @NotEmpty(message = "Username must not be empty.")
    @Size(min = 5,max = 20,message = "Username must be between 5 and 20 characters.")
    @UniqueUsername
    private String username;

    @NotEmpty
    @Size(min = 5,max = 20)
    private String fullName;
    @NotEmpty
    @Email
    @UniqueEmail
    private String email;
    @NotEmpty
    @Positive
    @DecimalMax(value = "90")
    private String age;
    @NotEmpty
    @Size(min = 5,max = 20)
    private String password;
    @NotEmpty
    @Size(min = 5,max = 20)
    private String confirmPassword;


    public UserRegisterDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterDto setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAge() {
        return age;
    }

    public UserRegisterDto setAge(String age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegisterDto{" +
                "username='" + username + '\'' +
                ", fullname='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
