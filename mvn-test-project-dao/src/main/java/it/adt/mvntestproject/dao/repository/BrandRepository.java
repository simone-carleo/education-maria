package it.adt.mvntestproject.dao.repository;

import it.adt.mvntestproject.dao.entity.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    Brand findById(int id_brand);

}
