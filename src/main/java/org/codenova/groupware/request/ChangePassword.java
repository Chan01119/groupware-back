package org.codenova.groupware.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ChangePassword {
    @NotBlank
    private String employeeId;
    @NotBlank
    private String oldPassword;
    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).+")  //정규표현식 = 문자열
    private String newPassword;

}
