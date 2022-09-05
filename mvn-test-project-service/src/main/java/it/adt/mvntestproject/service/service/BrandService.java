package it.adt.mvntestproject.service.service;

import it.adt.mvntestproject.dao.entity.Brand;
import it.adt.mvntestproject.dto.BrandDto;

public interface BrandService {
    Brand create(BrandDto brandDto);
    Brand findById(int id_brand);
}
