package in.multitools.partial.update.example.mapper;

import in.multitools.partial.update.example.dto.UserPatchDto;
import in.multitools.partial.update.example.entity.User;
import in.multitools.partial.update.example.model.UserModel;
import partial.update.mapper.PartialUpdateMapper;

public interface UserPatchMapper extends PartialUpdateMapper {

	default void test() {};

	UserModel toModel(UserPatchDto user);

	void toEntity(User entity, UserModel model);

}
