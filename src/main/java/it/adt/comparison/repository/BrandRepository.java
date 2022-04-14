package it.adt.comparison.repository;

import it.adt.comparison.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Brand findById(int id_brand);
}
