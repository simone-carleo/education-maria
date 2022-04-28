package it.adt.mvntestproject.dao.filter;

import com.querydsl.core.types.Predicate;

public interface PurchaseFilter {
    Predicate buildQuery();
}
