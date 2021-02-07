package in.multitools.patch.tools.example.mapper;

import in.multitools.patch.tools.example.dto.UserCreateDto;
import in.multitools.patch.tools.example.dto.UserDeleteDto;
import in.multitools.patch.tools.example.dto.UserGetDto;
import in.multitools.patch.tools.example.dto.UserUpdateDto;
import in.multitools.patch.tools.example.entity.User;
import in.multitools.patch.tools.example.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserModel toModel(User user);

	UserModel toModel(UserCreateDto createDto);

	UserModel toModel(UserUpdateDto updateDto);

	User toEntity(UserModel model);

	@Mapping(target = "id", ignore = true)
	User toEntity(@MappingTarget User entity, UserModel model);

	UserDeleteDto toDeleteDto(UserModel model);

	UserGetDto toGetDto(UserModel model);

}
