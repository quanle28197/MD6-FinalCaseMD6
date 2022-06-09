package com.codegym.finalproject.service.recuitmentNew;

import com.codegym.finalproject.model.entity.RecuitmentNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RecuitmentNewService implements IRecuitmentNewService{

    @Autowired
    private IRecuitmentNewService recuitmentNewRepository;

    @Override
    public Iterable<RecuitmentNew> findAll() {
        return recuitmentNewRepository.findAll();
    }

    @Override
    public Page<RecuitmentNew> findAll(Pageable pageable) {
        return recuitmentNewRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        recuitmentNewRepository.deleteById(id);
    }

    @Override
    public Optional<RecuitmentNew> findById(Long id) {
        return recuitmentNewRepository.findById(id);
    }

    @Override
    public RecuitmentNew save(RecuitmentNew recuitmentNew) {
        return recuitmentNewRepository.save(recuitmentNew);
    }

}
