package in.multitools.patch.tools.example.model;

import lombok.Data;
import patch.tools.annotation.ChangeLogger;

import java.time.LocalDate;

@Data
@ChangeLogger
public class UserModel {

	private Long id;
	private String login;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private boolean active;

}
