package za.co.entelect.jbootcamp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.entelect.jbootcamp.domain.GoalType;

public interface GoalTypeRepository extends JpaRepository<GoalType, Integer> {
}
