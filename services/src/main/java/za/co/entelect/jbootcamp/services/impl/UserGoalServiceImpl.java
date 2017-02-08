package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.domain.UserGoal;
import za.co.entelect.jbootcamp.persistence.UserGoalRepository;
import za.co.entelect.jbootcamp.services.UserGoalService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserGoalServiceImpl implements UserGoalService {
    private UserGoalRepository userGoalRepository;

    @Autowired
    public UserGoalServiceImpl(UserGoalRepository userGoalRepository) {
        this.userGoalRepository = userGoalRepository;
    }

    @Override
    public UserGoal findById(int id) {
        return userGoalRepository.findOne(id);
    }

    @Override
    public List<UserGoal> findAll() {
        return userGoalRepository.findAll();
    }

    @Override
    public Page<UserGoal> findAll(Pageable pageable) {
        return userGoalRepository.findAll(pageable);
    }

    @Override
    public List<UserGoal> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<UserGoal> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return userGoalRepository.count();
    }

    @Override
    @Transactional
    public UserGoal create(UserGoal object) {
        return userGoalRepository.save(object);
    }

    @Override
    @Transactional
    public UserGoal update(UserGoal object) {
        return userGoalRepository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }

    @Override
    public Page<UserGoal> findByUserId(int userId, Pageable pageable) {
        return userGoalRepository.findByUserFitnessProfileId(userId, pageable);
    }
}
