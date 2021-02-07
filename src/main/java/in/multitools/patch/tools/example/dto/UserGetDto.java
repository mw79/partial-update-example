package in.multitools.patch.tools.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserGetDto {

	private Long id;
	private String login;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private Boolean active;

}
