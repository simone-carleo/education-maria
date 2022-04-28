package it.adt.mvntestproject.dao.repository;

import it.adt.mvntestproject.dao.entity.Purchase;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Integer>, QuerydslPredicateExecutor<Purchase> {
}
