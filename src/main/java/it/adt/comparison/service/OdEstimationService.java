package it.adt.comparison.service;

import it.adt.comparison.dao.entity.OdEstimationEntity;

import java.util.List;
import java.util.Optional;

public interface OdEstimationService {

    //Save operation
    OdEstimationEntity saveEntity(OdEstimationEntity odEstimationEntity);

    //findAll operation
    List<OdEstimationEntity> findAllEntity();

    //findById operation
    Optional<OdEstimationEntity> findByIdEntity(int id);

    //delete operation
    void deleteById(int id);
}
