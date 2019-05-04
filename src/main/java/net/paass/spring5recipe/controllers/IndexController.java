package net.paass.spring5recipe.controllers;

import net.paass.spring5recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  private final RecipeService recipeService;

  public IndexController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @RequestMapping({ "", "/", "index", "index.html" })
  public String getIndex(Model model) {
    model.addAttribute("recipes", recipeService.getAllRecipes());
    return "index";
  }

  @RequestMapping("/{id}")
  public String getReceipt(Model model, @PathVariable Long id) {
    model.addAttribute("recipe", recipeService.getRecipeById(id));
    return "recipe";
  }

}
