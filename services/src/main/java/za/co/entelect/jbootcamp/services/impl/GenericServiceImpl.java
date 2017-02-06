package za.co.entelect.jbootcamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import za.co.entelect.jbootcamp.services.GenericService;

import java.util.ArrayList;
import java.util.List;

public class GenericServiceImpl<T, S extends JpaRepository<T, Integer>> implements GenericService<T> {
    @Autowired
    S repository;

    @Override
    public T findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<T> findByProperty(String property, String searchCriteria) {
        return findByProperty(property, searchCriteria, new PageRequest(0, Integer.MAX_VALUE)).getContent();
    }

    @Override
    public Page<T> findByProperty(String property, String searchCriteria, Pageable pageable) {
        return new PageImpl<>(new ArrayList<>());
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    @Transactional
    public T create(T object) {
        return repository.save(object);
    }

    @Override
    @Transactional
    public T update(T object) {
        return repository.save(object);
    }

    @Override
    public List<String> getSearchProperties() {
        return null;
    }

}
