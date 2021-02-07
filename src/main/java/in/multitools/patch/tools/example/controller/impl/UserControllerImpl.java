package in.multitools.patch.tools.example.controller.impl;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import in.multitools.patch.tools.example.controller.UserController;
import in.multitools.patch.tools.example.dto.UserCreateDto;
import in.multitools.patch.tools.example.dto.UserDeleteDto;
import in.multitools.patch.tools.example.dto.UserGetDto;
import in.multitools.patch.tools.example.dto.UserPatchDto;
import in.multitools.patch.tools.example.dto.UserUpdateDto;
import in.multitools.patch.tools.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserControllerImpl implements UserController {

	private final UserService userService;

	@Override
	@PostMapping
	public Long create(@RequestBody UserCreateDto user) {
		return userService.create(user);
	}

	@Override
	@GetMapping("/{id}")
	public UserGetDto read(@PathVariable("id") Long id) {
		return userService.read(id);
	}

	@Override
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody UserUpdateDto user) {
		userService.update(id, user);
	}

	@Override
	@DeleteMapping("/{id}")
	public UserDeleteDto delete(@PathVariable("id") Long id) {
		return userService.delete(id);
	}

	@Override
	@GetMapping("/list")
	public List<UserGetDto> list() {
		return userService.list();
	}

	@Override
	@JsonDeserialize()
	@PatchMapping("/{id}")
	public UserGetDto patch(@PathVariable("id") Long id, @RequestBody UserPatchDto user) {
		return userService.patch(id, user);
	}

}
