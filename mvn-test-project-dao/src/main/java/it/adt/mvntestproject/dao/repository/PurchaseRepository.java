package it.adt.mvntestproject.dao.repository;

import it.adt.mvntestproject.dao.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface PurchaseRepository extends JpaRepository<Purchase, Long>, QuerydslPredicateExecutor<Purchase> {
}
