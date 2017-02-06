package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface GenericService<T> {
    T findById(int id);
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    List<T> findByProperty(String property, String searchCriteria);
    Page<T> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    T create(T object);
    T update(T object);
    List<String> getSearchProperties();
}
