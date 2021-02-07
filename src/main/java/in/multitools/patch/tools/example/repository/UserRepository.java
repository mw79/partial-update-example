package in.multitools.patch.tools.example.repository;

import in.multitools.patch.tools.example.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
