package com.codegym.finalproject.service.skill;

import com.codegym.finalproject.model.entity.Skill;
import com.codegym.finalproject.repository.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillService implements ISkillService{
    @Autowired
    private ISkillRepository skillRepository;

    @Override
    public Iterable<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Page<Skill> findAll(Pageable pageable) {
        return skillRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    @Override
    public Iterable<Skill> findAllSkillsByCvId(Long id) {
        return skillRepository.findAllByCv_Id(id);
    }

    @Override
    public Boolean existByCv_Id(Long id) {
        return skillRepository.existByCv_Id(id);
    }

    @Override
    public boolean existById(Long id) {
        return skillRepository.existById(id);
    }
}
