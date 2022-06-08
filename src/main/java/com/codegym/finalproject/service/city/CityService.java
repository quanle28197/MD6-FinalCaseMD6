package com.codegym.finalproject.service.city;

import com.codegym.finalproject.model.entity.City;
import com.codegym.finalproject.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CityService implements ICityService{

    @Autowired
    private ICityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public City save(City city) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
