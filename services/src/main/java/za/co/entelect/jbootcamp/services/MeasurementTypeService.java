package za.co.entelect.jbootcamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.entelect.jbootcamp.domain.MeasurementType;

import java.util.List;

public interface MeasurementTypeService {
    MeasurementType findById(int id);
    List<MeasurementType> findAll();
    Page<MeasurementType> findAll(Pageable pageable);
    List<MeasurementType> findByProperty(String property, String searchCriteria);
    Page<MeasurementType> findByProperty(String property, String searchCriteria, Pageable pageable);
    long count();
    MeasurementType create(MeasurementType object);
    MeasurementType update(MeasurementType object);
    List<String> getSearchProperties();
}
