package net.paass.spring5recipe.services;

import java.util.Set;
import net.paass.spring5recipe.domain.Recipe;

public interface RecipeService {

  Set<Recipe> getRecipes();

}
