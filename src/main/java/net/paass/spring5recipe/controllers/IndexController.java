package net.paass.spring5recipe.controllers;

import java.util.Optional;
import net.paass.spring5recipe.domain.Category;
import net.paass.spring5recipe.domain.UnitOfMeasure;
import net.paass.spring5recipe.repositories.CategoryRepository;
import net.paass.spring5recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  private CategoryRepository categoryRepository;
  private UnitOfMeasureRepository unitOfMeasureRepository;

  public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  @RequestMapping({ "", "/", "index", "index.html" })
  public String getIndex() {

    Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
    Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
    System.out.println("Category Id: " + categoryOptional.get().getId());
    System.out.println("Unit of Measure Id: " + unitOfMeasureOptional.get().getId());
    return "index";
  }

}
