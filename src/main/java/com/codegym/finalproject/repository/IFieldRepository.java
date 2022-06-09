package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFieldRepository extends JpaRepository<Field,Long> {
}
