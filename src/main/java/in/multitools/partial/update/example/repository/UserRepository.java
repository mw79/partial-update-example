package in.multitools.partial.update.example.repository;

import in.multitools.partial.update.example.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
