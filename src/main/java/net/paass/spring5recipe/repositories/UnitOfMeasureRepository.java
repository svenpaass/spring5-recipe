package net.paass.spring5recipe.repositories;

import java.util.Optional;
import net.paass.spring5recipe.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

  Optional<UnitOfMeasure> findByDescription(String description);

}
