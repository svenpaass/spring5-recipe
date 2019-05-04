package net.paass.spring5recipe.repositories;

import net.paass.spring5recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
