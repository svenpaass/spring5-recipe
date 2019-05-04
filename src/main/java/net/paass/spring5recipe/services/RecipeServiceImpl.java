package net.paass.spring5recipe.services;

import java.util.HashSet;
import java.util.Optional;
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
  public Set<Recipe> getAllRecipes() {
    Set<Recipe> recipes = new HashSet<Recipe>();
    for ( Recipe recipe : recipeRepository.findAll() ) {
      recipes.add(recipe);
    }
    return recipes;
  }

  @Override
  public Recipe getRecipeById(Long id) {
    Optional<Recipe> recipeOptional = recipeRepository.findById(id);
    return recipeOptional.get();
  }
}
