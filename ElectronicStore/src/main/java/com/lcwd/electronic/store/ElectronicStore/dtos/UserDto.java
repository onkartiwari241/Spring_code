package com.lcwd.electronic.store.ElectronicStore.dtos;

import com.lcwd.electronic.store.ElectronicStore.validate.ImageNameValid;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDto {
    private  String userId;

    @Size(min = 3, max = 20, message = "invalid name !!")
    private String name;

//    @Email(message = "invalid user email !!")

    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "invalid email")
    @NotBlank(message = "email can't be empty !!...")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @Size(min = 3,max = 6,message = "invalid gender")
    private String gender;

    @NotBlank(message = "Invalid about field")
    private String about;

    @ImageNameValid
    private String image;
}
