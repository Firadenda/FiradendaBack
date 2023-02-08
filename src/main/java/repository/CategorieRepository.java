package repository;

import entity.Categorie;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategorieRepository extends CrudRepository<Categorie,Long> {
    long deleteByNameLike(String name);
    Optional<Categorie> findByNameLike(String name);
}
