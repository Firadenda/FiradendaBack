package repository;

import entity.Command;
import org.springframework.data.repository.CrudRepository;

public interface CommandRepository extends CrudRepository<Command,Long> {
}
