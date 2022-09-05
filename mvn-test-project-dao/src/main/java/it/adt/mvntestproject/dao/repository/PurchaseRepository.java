package it.adt.mvntestproject.dao.repository;

import it.adt.mvntestproject.dao.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


public interface PurchaseRepository extends JpaRepository<Purchase, Long>, QuerydslPredicateExecutor<Purchase> {
}
