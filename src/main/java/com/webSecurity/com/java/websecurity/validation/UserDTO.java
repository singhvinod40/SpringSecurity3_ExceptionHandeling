package com.webSecurity.com.java.websecurity.validation;


import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotNull(message = "user Name can not be null")
    private String name;
    @Email
    private String email;
    @NotNull @Pattern(regexp = "^\\d{10}$")
    private String mobile;

    private String gender;
    @Min(18)@Max(70)
    private String age;
    @NotBlank
    private String Nationality;
}
