package net.paass.spring5recipe.bootstrap;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import net.paass.spring5recipe.domain.Category;
import net.paass.spring5recipe.domain.Ingredient;
import net.paass.spring5recipe.domain.Notes;
import net.paass.spring5recipe.domain.Recipe;
import net.paass.spring5recipe.domain.UnitOfMeasure;
import net.paass.spring5recipe.repositories.CategoryRepository;
import net.paass.spring5recipe.repositories.RecipeRepository;
import net.paass.spring5recipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

  private final CategoryRepository categoryRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;
  private final RecipeRepository recipeRepository;

  public DataLoader(CategoryRepository categoryRepository,
      UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
    this.recipeRepository = recipeRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Recipe guacamuleRecipe = getGuacamoleRecipe();
    recipeRepository.save(guacamuleRecipe);

    Recipe grilledChickenTacosRecipe = getGrilledChickenTacosRecipe();
    recipeRepository.save(grilledChickenTacosRecipe);

  }

  private Recipe getGrilledChickenTacosRecipe() {
    Recipe grilledChickenTacosRecipe = new Recipe();

    grilledChickenTacosRecipe.setDescription("Spicy Grilled Chicken Tacos Recipe");
    grilledChickenTacosRecipe.setPrepTime(20);
    grilledChickenTacosRecipe.setCookTime(15);
    grilledChickenTacosRecipe.setServings(4);
    grilledChickenTacosRecipe.setSource("Sally Vargas");
    grilledChickenTacosRecipe
        .setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
    grilledChickenTacosRecipe.setDirections(
        "<div><p><strong>1 Prepare a gas or charcoal grill for medium-high, direct heat.</strong></p>\n"
            + "<p><strong>2 Make the marinade and coat the chicken:</strong> In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.</p>\n"
            + "<p>Set aside to marinate while the grill heats and you prepare the rest of the toppings.</p>\n"
            + "<p><img width=\"600\" height=\"400\" src=\"https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-600x400.jpg\" class=\"attachment-sr-venti size-sr-venti lazyautosizes lazyloaded\" alt=\"Spicy Grilled Chicken Tacos\" srcset=\"https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1.jpg 1200w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-300x200.jpg 300w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-768x512.jpg 768w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-1024x683.jpg 1024w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-600x400.jpg 600w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-440x293.jpg 440w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-200x133.jpg 200w\" sizes=\"261px\" data-srcset=\"https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1.jpg 1200w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-300x200.jpg 300w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-768x512.jpg 768w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-1024x683.jpg 1024w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-600x400.jpg 600w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-440x293.jpg 440w, https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-200x133.jpg 200w\" data-sizes=\"auto\" data-src=\"https://www.simplyrecipes.com/wp-content/uploads/2017/05/2017-05-29-GrilledChickenTacos-1-600x400.jpg\" nopin=\"nopin\" style=\"display: none;\"></p>\n"
            + "<p><strong>3 Grill the chicken: </strong>Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.</p>\n"
            + "<p><strong>4</strong> <strong>Warm the tortillas</strong>: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.</p>\n"
            + "<p>Wrap warmed tortillas in a tea towel to keep them warm until serving.</p>\n"
            + "<p><strong>5 Assemble the tacos:</strong> Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.</p>\n"
            + "</div>");
    grilledChickenTacosRecipe.setRating(5);

    Set<Ingredient> ingredients = new HashSet<>();

    UnitOfMeasure teaSpoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
    UnitOfMeasure tableSpoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
    UnitOfMeasure cup = unitOfMeasureRepository.findByDescription("Cup").get();
    UnitOfMeasure piece = unitOfMeasureRepository.findByDescription("Piece").get();

    Ingredient ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(2));
    ingredient.setUom(tableSpoon);
    ingredient.setDescription("ancho chili powder");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(1));
    ingredient.setUom(teaSpoon);
    ingredient.setDescription("dried oregano");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(1));
    ingredient.setUom(teaSpoon);
    ingredient.setDescription("dried cumin");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(1));
    ingredient.setUom(teaSpoon);
    ingredient.setDescription("sugar");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(0.5));
    ingredient.setUom(teaSpoon);
    ingredient.setDescription("salt");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(1));
    ingredient.setUom(piece);
    ingredient.setDescription("garlic, finely chopped");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(1));
    ingredient.setUom(tableSpoon);
    ingredient.setDescription("finely grated orange zest");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(3));
    ingredient.setUom(tableSpoon);
    ingredient.setDescription("fresh-squeezed orange juice");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(2));
    ingredient.setUom(tableSpoon);
    ingredient.setDescription("olive oil");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(4));
    ingredient.setUom(piece);
    ingredient.setDescription("skinless, boneless chicken thighs (1 1/4 pounds)");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(8));
    ingredient.setUom(piece);
    ingredient.setDescription("small corn tortillas");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(3));
    ingredient.setUom(cup);
    ingredient.setDescription("packed baby arugula (3 ounces)");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(2));
    ingredient.setUom(piece);
    ingredient.setDescription("medium ripe avocados, sliced");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(4));
    ingredient.setUom(piece);
    ingredient.setDescription("radishes, thinly sliced");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(0.25));
    ingredient.setUom(piece);
    ingredient.setDescription("red onion, thinly sliced");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(1));
    ingredient.setUom(piece);
    ingredient.setDescription("roughly chopped cilantro");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(0.5));
    ingredient.setUom(cup);
    ingredient.setDescription("sour cream thinned with 1/4 cup milk");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(1));
    ingredient.setUom(piece);
    ingredient.setDescription("lime, cut into wedges");
    ingredient.setRecipe(grilledChickenTacosRecipe);
    ingredients.add(ingredient);

    grilledChickenTacosRecipe.setIngredients(ingredients);

    Set<Category> categories = new HashSet<>();
    categories.add(categoryRepository.findByDescription("Fast Food").get());
    grilledChickenTacosRecipe.setCategories(categories);

    Notes notes = new Notes();
    notes.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)");
    notes.setRecipe(grilledChickenTacosRecipe);
    grilledChickenTacosRecipe.setNotes(notes);

    return grilledChickenTacosRecipe;
  }

  private Recipe getGuacamoleRecipe() {
    Recipe guacamuleRecipe = new Recipe();

    guacamuleRecipe.setDescription("How to Make Perfect Guacamole Recipe");
    guacamuleRecipe.setPrepTime(10);
    guacamuleRecipe.setCookTime(0);
    guacamuleRecipe.setServings(2);
    guacamuleRecipe.setSource("Elise Bauer");
    guacamuleRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
    guacamuleRecipe.setDirections(
        "<div><p><b>1 Cut avocado, remove flesh:</b> Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See <a href=\"https://www.simplyrecipes.com/recipes/how_to_cut_and_peel_an_avocado/\">How to Cut and Peel an Avocado</a>.) Place in a bowl.</p>\n"
            + "<p><img width=\"600\" height=\"400\" src=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-600x400.jpg\" class=\"attachment-sr-venti size-sr-venti lazyautosizes lazyloaded\" alt=\"\" srcset=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800.jpg 800w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-300x200.jpg 300w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-768x512.jpg 768w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-600x400.jpg 600w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-440x293.jpg 440w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-200x133.jpg 200w\" sizes=\"270px\" data-srcset=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800.jpg 800w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-300x200.jpg 300w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-768x512.jpg 768w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-600x400.jpg 600w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-440x293.jpg 440w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-200x133.jpg 200w\" data-sizes=\"auto\" data-src=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-1-800-600x400.jpg\" nopin=\"nopin\" style=\"display: none;\"></p>\n"
            + "<p><b>2 Mash with a fork:</b>&nbsp;Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)</p>\n"
            + "<p><img width=\"600\" height=\"400\" src=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-600x400.jpg\" class=\"attachment-sr-venti size-sr-venti lazyautosizes lazyloaded\" alt=\"\" srcset=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800.jpg 800w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-300x200.jpg 300w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-768x512.jpg 768w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-600x400.jpg 600w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-440x293.jpg 440w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-200x133.jpg 200w\" sizes=\"270px\" data-srcset=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800.jpg 800w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-300x200.jpg 300w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-768x512.jpg 768w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-600x400.jpg 600w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-440x293.jpg 440w, https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-200x133.jpg 200w\" data-sizes=\"auto\" data-src=\"https://www.simplyrecipes.com/wp-content/uploads/2014/05/guacamole-method-2-800-600x400.jpg\" nopin=\"nopin\" style=\"display: none;\"></p>\n"
            + "<p><strong>3 Add salt, lime juice, and the rest:</strong>&nbsp;Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.</p>\n"
            + "<p>Add the chopped onion, cilantro, black pepper, and chiles.&nbsp;Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.</p>\n"
            + "<p>Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.</p>\n"
            + "<p><b>4 Cover with plastic and chill to store:</b>&nbsp;Place&nbsp;plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole&nbsp;brown.) Refrigerate until ready to serve.</p>\n"
            + "<p>Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.</p>\n"
            + "<p><b>Variations</b></p>\n"
            + "<p>For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.</p>\n"
            + "<p>Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added&nbsp;pineapple, mango, or strawberries (see our <a href=\"https://www.simplyrecipes.com/recipes/strawberry_guacamole/\">Strawberry Guacamole</a>).</p>\n"
            + "<p>The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.</p>\n"
            + "<p>To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.</p>\n"
            + "<p>For a deviled egg version with guacamole, try our <a href=\"https://www.simplyrecipes.com/recipes/guacamole_deviled_eggs/\">Guacamole Deviled Eggs</a>!</p>\n"
            + "</div>");
    guacamuleRecipe.setRating(5);

    Set<Ingredient> ingredients = new HashSet<>();

    UnitOfMeasure teaSpoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
    UnitOfMeasure tableSpoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
    UnitOfMeasure dash = unitOfMeasureRepository.findByDescription("Dash").get();
    UnitOfMeasure piece = unitOfMeasureRepository.findByDescription("Piece").get();

    Ingredient ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(2));
    ingredient.setUom(piece);
    ingredient.setDescription("ripe avocados");
    ingredient.setRecipe(guacamuleRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(0.5));
    ingredient.setUom(teaSpoon);
    ingredient.setDescription("Kosher salt");
    ingredient.setRecipe(guacamuleRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(1));
    ingredient.setUom(tableSpoon);
    ingredient.setDescription("fresh lime juice or lemon juice");
    ingredient.setRecipe(guacamuleRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(2));
    ingredient.setUom(tableSpoon);
    ingredient.setDescription("minced red onion or thinly sliced green onion");
    ingredient.setRecipe(guacamuleRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(2));
    ingredient.setUom(piece);
    ingredient.setDescription("serrano chiles, stems and seeds removed, minced");
    ingredient.setRecipe(guacamuleRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(1));
    ingredient.setUom(dash);
    ingredient.setDescription("freshly grated black pepper");
    ingredient.setRecipe(guacamuleRecipe);
    ingredients.add(ingredient);

    ingredient = new Ingredient();
    ingredient.setAmount(new BigDecimal(0.5));
    ingredient.setUom(piece);
    ingredient.setDescription("ripe tomato, seeds and pulp removed, chopped");
    ingredient.setRecipe(guacamuleRecipe);
    ingredients.add(ingredient);

    guacamuleRecipe.setIngredients(ingredients);

    Set<Category> categories = new HashSet<>();
    categories.add(categoryRepository.findByDescription("Dip").get());
    categories.add(categoryRepository.findByDescription("Mexican").get());
    categories.add(categoryRepository.findByDescription("Vegan").get());
    categories.add(categoryRepository.findByDescription("Avocado").get());
    guacamuleRecipe.setCategories(categories);

    Notes notes = new Notes();
    notes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
    notes.setRecipe(guacamuleRecipe);
    guacamuleRecipe.setNotes(notes);

    return guacamuleRecipe;
  }

}
