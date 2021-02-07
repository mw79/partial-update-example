package in.multitools.patch.tools.example.mapper;

import in.multitools.patch.tools.example.dto.UserPatchDto;
import in.multitools.patch.tools.example.entity.User;
import in.multitools.patch.tools.example.model.UserModel;
import patch.tools.mapper.PatchMapper;

public interface UserPatchMapper extends PatchMapper {

	default void test() {};

	UserModel toModel(UserPatchDto user);

	void toEntity(User entity, UserModel model);

}
