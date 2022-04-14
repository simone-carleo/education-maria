package it.adt.comparison.service.impl;

import it.adt.comparison.Brand;
import it.adt.comparison.Product;
import it.adt.comparison.dto.BrandDto;
import it.adt.comparison.repository.BrandRepository;
import it.adt.comparison.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand create(BrandDto brandDto){
        Brand brand = new Brand();
        brand.setBrandName(brandDto.getName());
        brand.setBrandDescription(brandDto.getDescription());
        return this.brandRepository.save(brand);

    }

    public Brand findById(int id_brand){
        Brand brand = brandRepository.findById(id_brand);
        return brand;
    }



}
