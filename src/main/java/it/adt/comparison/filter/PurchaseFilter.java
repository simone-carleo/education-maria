package it.adt.comparison.filter;

import com.querydsl.core.types.Predicate;

public interface PurchaseFilter {
    Predicate buildQuery();
}
