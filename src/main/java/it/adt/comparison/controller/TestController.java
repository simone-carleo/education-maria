package it.adt.comparison.controller;


import it.adt.comparison.dao.entity.OdErrorDetectionEntity;
import it.adt.comparison.dao.entity.OdEstimationEntity;
import it.adt.comparison.dao.entity.OdWeightFactorEntity;
import it.adt.comparison.dao.repository.OdErrorDetectionRepository;
import it.adt.comparison.dao.repository.OdWeightFactorRepository;
import it.adt.comparison.service.OdEstimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "api/v1")
public class TestController {

    @Autowired
    private OdEstimationService odEstimationService;

    @Autowired
    private OdErrorDetectionRepository odErrorDetectionRepository;

    @Autowired
    private OdWeightFactorRepository odWeightFactorRepository;

    @PostMapping(value = "/estimation", produces = { MediaType.APPLICATION_JSON_VALUE})
    public OdEstimationEntity saveEntity(@RequestBody OdEstimationEntity odEstimationEntity){
        return odEstimationService.saveEntity(odEstimationEntity);
    }

    @GetMapping(value = "/estimation/findAll",produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<OdEstimationEntity> findAllEntity(){
        return odEstimationService.findAllEntity();
    }

    @GetMapping(value = "/estimation/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<OdEstimationEntity> findByIdEntity(@PathVariable(value = "id", required = true) int id){
        return odEstimationService.findByIdEntity(id);
    }

    @DeleteMapping(value = "estimation/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteEntity(@PathVariable(value = "id", required = true) int id){
        odEstimationService.deleteById(id);
    }

    @PostMapping(value = "/errorD", produces = {MediaType.APPLICATION_JSON_VALUE})
    public OdErrorDetectionEntity saveEDetectionEntity(@RequestBody OdErrorDetectionEntity odErrorDetectionEntity){
        return odErrorDetectionRepository.save(odErrorDetectionEntity);
    }

    @GetMapping(value = "/errorD/findAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<OdErrorDetectionEntity> findAllEDetectionEntity(){
        return (List<OdErrorDetectionEntity>) odErrorDetectionRepository.findAll();
    }

    @GetMapping(value = "errorD/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<OdErrorDetectionEntity> findByIdEDetectionEntity(@PathVariable(value = "id", required = true) int id){
        return odErrorDetectionRepository.findById(id);
    }

    @GetMapping(value = "errorD/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteEDetectionEntity(@PathVariable(value = "id", required = true) int id){
        odErrorDetectionRepository.deleteById(id);
    }

    @PostMapping(value = "/wfactor", produces = {MediaType.APPLICATION_JSON_VALUE})
    public OdWeightFactorEntity saveWFactorEntity(@RequestBody OdWeightFactorEntity odWeightFactorEntity){
        return odWeightFactorRepository.save(odWeightFactorEntity);
    }

    @GetMapping(value = "/wfactor/findAll", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<OdWeightFactorEntity> findAllWFactorEntity(){
        return (List<OdWeightFactorEntity>) odWeightFactorRepository.findAll();
    }

    @GetMapping(value = "/wfactor/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<OdWeightFactorEntity> findByIdWFactorEntity(@PathVariable(value = "id", required = true) int id){
        return odWeightFactorRepository.findById(id);
    }

    @DeleteMapping(value = "wfactor/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteWFactorEntity(@PathVariable(value = "id", required = true) int id){
        odWeightFactorRepository.deleteById(id);
    }
}
