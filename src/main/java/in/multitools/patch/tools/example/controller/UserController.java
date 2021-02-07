package in.multitools.patch.tools.example.controller;

import in.multitools.patch.tools.example.dto.UserCreateDto;
import in.multitools.patch.tools.example.dto.UserDeleteDto;
import in.multitools.patch.tools.example.dto.UserGetDto;
import in.multitools.patch.tools.example.dto.UserPatchDto;
import in.multitools.patch.tools.example.dto.UserUpdateDto;

import java.util.List;

public interface UserController {

	Long create(UserCreateDto user);

	UserGetDto read(Long id);

	void update(Long id, UserUpdateDto user);

	UserDeleteDto delete(Long id);

	List<UserGetDto> list();

	UserGetDto patch(Long id, UserPatchDto user);

}
