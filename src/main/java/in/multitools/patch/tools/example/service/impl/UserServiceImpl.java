package in.multitools.patch.tools.example.service.impl;

import in.multitools.patch.tools.example.dto.UserCreateDto;
import in.multitools.patch.tools.example.dto.UserDeleteDto;
import in.multitools.patch.tools.example.dto.UserGetDto;
import in.multitools.patch.tools.example.dto.UserPatchDto;
import in.multitools.patch.tools.example.dto.UserUpdateDto;
import in.multitools.patch.tools.example.entity.User;
import in.multitools.patch.tools.example.mapper.UserMapper;
import in.multitools.patch.tools.example.mapper.UserPatchMapper;
import in.multitools.patch.tools.example.model.UserModel;
import in.multitools.patch.tools.example.repository.UserRepository;
import in.multitools.patch.tools.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final UserPatchMapper userPatchMapper;

	@Transactional
	@Override
	public Long create(UserCreateDto user) {
		UserModel model = userMapper.toModel(user);
		User entity = userRepository.save(userMapper.toEntity(model));
		return entity.getId();
	}

	@Override
	public UserGetDto read(Long id) {
		return userRepository
				.findById(id)
				.map(userMapper::toModel)
				.map(userMapper::toGetDto)
				.orElseThrow(EntityNotFoundException::new);
	}

	@Transactional
	@Override
	public void update(Long id, UserUpdateDto user) {
		User modifiedEntity = userRepository
				.findById(id)
				.map(entity -> userMapper.toEntity(entity, userMapper.toModel(user)))
				.orElseThrow(EntityNotFoundException::new);
		userRepository.save(modifiedEntity);
	}

	@Transactional
	@Override
	public UserDeleteDto delete(Long id) {
		UserDeleteDto user = userRepository
				.findById(id)
				.map(userMapper::toModel)
				.map(userMapper::toDeleteDto)
				.orElseThrow(EntityNotFoundException::new);
		userRepository.deleteById(id);
		return user;
	}

	@Override
	public List<UserGetDto> list() {
		return StreamSupport
				.stream(userRepository.findAll().spliterator(), false)
				.map(userMapper::toModel)
				.map(userMapper::toGetDto)
				.collect(Collectors.toList());
	}

	@Transactional
	@Override
	public UserGetDto patch(Long id, UserPatchDto user) {
		User entity = userRepository
				.findById(id)
				.orElseThrow(EntityNotFoundException::new);
		UserModel model = userPatchMapper.toModel(user);
		userPatchMapper.toEntity(entity, model);
		return userMapper.toGetDto(userMapper.toModel(userRepository.save(entity)));
	}
}
