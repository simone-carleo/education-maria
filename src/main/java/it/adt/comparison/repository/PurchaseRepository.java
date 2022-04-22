package it.adt.comparison.repository;

import it.adt.comparison.Purchase;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Integer>, QuerydslPredicateExecutor<Purchase> {
}
