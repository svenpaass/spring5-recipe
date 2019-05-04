package net.paass.spring5recipe.repositories;

import net.paass.spring5recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository  extends CrudRepository<Recipe, Long> {

}
