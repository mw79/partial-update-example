package in.multitools.partial.update.example.mapper;

import in.multitools.partial.update.example.entity.User;
import in.multitools.partial.update.example.dto.UserCreateDto;
import in.multitools.partial.update.example.dto.UserDeleteDto;
import in.multitools.partial.update.example.dto.UserGetDto;
import in.multitools.partial.update.example.dto.UserUpdateDto;
import in.multitools.partial.update.example.model.UserModel;
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
