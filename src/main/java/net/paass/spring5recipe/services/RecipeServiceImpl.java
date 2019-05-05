package net.paass.spring5recipe.services;

import java.util.HashSet;
import java.util.Set;
import net.paass.spring5recipe.domain.Recipe;
import net.paass.spring5recipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

  private final RecipeRepository recipeRepository;

  public RecipeServiceImpl(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public Set<Recipe> getRecipes() {
    Set<Recipe> recipes = new HashSet<Recipe>();

    recipeRepository.findAll().iterator().forEachRemaining(recipes::add);

    return recipes;
  }

}
