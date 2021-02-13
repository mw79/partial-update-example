package in.multitools.partial.update.example.model;

import lombok.Data;
import partial.update.annotation.ChangeLogger;

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
