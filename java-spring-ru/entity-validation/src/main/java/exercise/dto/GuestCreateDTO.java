package exercise.dto;

// BEGIN

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Getter
@Setter
public class GuestCreateDTO {
    @NotNull
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "^\\+\\d{11,13}$")
    private String phoneNumber;
    @Size(min = 4)
    private String clubCard;
    @Future
    private LocalDate cardValidUntil;
    // END
}
// END
