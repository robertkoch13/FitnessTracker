package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.UserGoal;

import java.util.List;

public interface UserGoalService {
    UserGoal findById(int id);
    List<UserGoal> findAll();
    Page<UserGoal> findAll(Pageable pageable);
    List<UserGoal> findByProperty(String property, String searchCriteria);
    Page<UserGoal> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    UserGoal create(UserGoal object);
    UserGoal update(UserGoal object);
    List<String> getSearchProperties();
    Page<UserGoal> findByUserId(int userId, Pageable pageable);

}
