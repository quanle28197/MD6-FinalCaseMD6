package com.codegym.finalproject.service.field;


import com.codegym.finalproject.model.entity.City;
import com.codegym.finalproject.model.entity.Field;
import com.codegym.finalproject.repository.IFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FieldService implements IFieldService{
    @Autowired
    private IFieldRepository fieldRepository;
    @Override
    public Iterable<Field> findAll() {
        return fieldRepository.findAll();
    }

    @Override
    public Optional<Field> findById(Long id) {
        return fieldRepository.findById(id);
    }

    @Override
    public Field save(Field field) {
        return fieldRepository.save(field);
    }

    @Override
    public void remove(Long id) {
        fieldRepository.deleteById(id);
    }
}
