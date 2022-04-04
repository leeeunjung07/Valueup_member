package hello.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberSaveDTO {

    @NotBlank
    private String memberEmail;
    @NotBlank
    private String memberPassword;
    private String memberName;

}
