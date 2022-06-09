package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICVRepository extends JpaRepository<CV, Long> {
    Boolean existByUserId(Long idUser);

    Optional<CV> findByUserId(Long id);
}
