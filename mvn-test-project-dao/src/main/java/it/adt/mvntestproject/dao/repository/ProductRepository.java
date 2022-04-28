package it.adt.mvntestproject.dao.repository;

import it.adt.mvntestproject.dao.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
