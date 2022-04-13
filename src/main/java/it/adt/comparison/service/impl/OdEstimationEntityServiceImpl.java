package it.adt.comparison.service.impl;

import it.adt.comparison.dao.entity.OdEstimationEntity;
import it.adt.comparison.dao.repository.OdEstimationRepository;
import it.adt.comparison.service.OdEstimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdEstimationEntityServiceImpl implements OdEstimationService {

    @Autowired
    private OdEstimationRepository odEstimationRepository;

    //save operation
    public OdEstimationEntity saveEntity(OdEstimationEntity odEstimationEntity){
        return odEstimationRepository.save(odEstimationEntity);
    }

    //findAll operation
    public List<OdEstimationEntity> findAllEntity(){
        return (List<OdEstimationEntity>) odEstimationRepository.findAll();
    }

    //findById operation
    public Optional<OdEstimationEntity> findByIdEntity(int id){
        return odEstimationRepository.findById(id);
    }

    //delete operation
    public void deleteById(int id){
        odEstimationRepository.deleteById(id);
    }
}
