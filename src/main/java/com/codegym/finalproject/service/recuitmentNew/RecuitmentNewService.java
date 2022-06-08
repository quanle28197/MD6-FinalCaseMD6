package com.codegym.finalproject.service.recuitmentNew;

import com.codegym.finalproject.model.entity.RecuitmentNew;
import com.codegym.finalproject.repository.IRecuitmentNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RecuitmentNewService implements IRecuitmentNewService{

    @Autowired
    private IRecuitmentNewRepository recuitmentNewRepository;

    @Override
    public Iterable<RecuitmentNew> findAll() {
        return recuitmentNewRepository.findAll();
    }

    @Override
    public Optional<RecuitmentNew> findById(Long id) {
        return recuitmentNewRepository.findById(id);
    }

    @Override
    public RecuitmentNew save(RecuitmentNew recuitmentNew) {
        return recuitmentNewRepository.save(recuitmentNew);
    }

    @Override
    public void removeById(Long id) {
       recuitmentNewRepository.deleteById(id);
    }
}
