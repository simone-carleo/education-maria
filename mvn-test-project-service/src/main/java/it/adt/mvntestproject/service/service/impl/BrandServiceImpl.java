package it.adt.mvntestproject.service.service.impl;

import it.adt.mvntestproject.dao.entity.Brand;
import it.adt.mvntestproject.dto.BrandDto;
import it.adt.mvntestproject.dao.repository.BrandRepository;
import it.adt.mvntestproject.service.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
