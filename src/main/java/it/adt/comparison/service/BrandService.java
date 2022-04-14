package it.adt.comparison.service;

import it.adt.comparison.Brand;
import it.adt.comparison.dto.BrandDto;

public interface BrandService {
    Brand create(BrandDto brandDto);
    Brand findById(int id_brand);
}
