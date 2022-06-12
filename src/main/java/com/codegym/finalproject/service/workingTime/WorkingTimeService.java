package com.codegym.finalproject.service.workingTime;

import com.codegym.finalproject.model.entity.WorkingTime;
import com.codegym.finalproject.repository.IWorkingTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkingTimeService implements IWorkingTimeService{
    @Autowired
    private IWorkingTimeRepository workingTimeRepository;
    @Override
    public Iterable<WorkingTime> findAll() {
        return workingTimeRepository.findAll();
    }

    @Override
    public Page<WorkingTime> findAll(Pageable pageable) {
        return workingTimeRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        workingTimeRepository.deleteById(id);
    }

    @Override
    public WorkingTime save(WorkingTime workingTime) {
        return workingTimeRepository.save(workingTime);
    }

    @Override
    public Optional<WorkingTime> findById(Long id) {
        return workingTimeRepository.findById(id);
    }
}
