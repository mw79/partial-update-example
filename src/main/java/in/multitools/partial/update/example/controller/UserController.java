package in.multitools.partial.update.example.controller;

import in.multitools.partial.update.example.dto.UserCreateDto;
import in.multitools.partial.update.example.dto.UserDeleteDto;
import in.multitools.partial.update.example.dto.UserGetDto;
import in.multitools.partial.update.example.dto.UserPatchDto;
import in.multitools.partial.update.example.dto.UserUpdateDto;

import java.util.List;

public interface UserController {

	Long create(UserCreateDto user);

	UserGetDto read(Long id);

	void update(Long id, UserUpdateDto user);

	UserDeleteDto delete(Long id);

	List<UserGetDto> list();

	UserGetDto patch(Long id, UserPatchDto user);

}
