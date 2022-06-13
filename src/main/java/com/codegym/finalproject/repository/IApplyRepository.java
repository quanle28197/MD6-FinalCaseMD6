package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.dto.response.ApplyShowAll;
import com.codegym.finalproject.model.entity.Apply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IApplyRepository extends JpaRepository<Apply, Long> {

    @Query(value = "select a.id as id, a.date as date, a.status as status, recuitment_new_id as recuitmentNewId, a.user_id as userId, r.title as title, vacancies_id as vacanciesId, v.name as vacanciesName, c.avatar as avatar, u.name as nameUser, u.phone as phoneUser from apply a join recuitmentnew r on a.recuitment_new_id = r.id join company c on r.company_id = c.id join city c2 on c2.id = c.city_id join field f on f.id = r.field_id join vacancies v on v.id = r.vacancies_id join user u on a.user_id = u.id where c.id = :idCompany",countQuery = "select a.id as id, a.date as date, a.status as status, recuitment_new_id as recuitmentNewId, a.user_id as userId, r.title as title, vacancies_id as vacanciesId, v.name as vacanciesName, c.avatar as avatar, u.name as nameUser, u.phone as phoneUser from apply a join recuitmentnew r on a.recuitment_new_id = r.id join company c on r.company_id = c.id join city c2 on c2.id = c.city_id join field f on f.id = r.field_id join vacancies v on v.id = r.vacancies_id join user u on a.user_id = u.id",nativeQuery = true)
    Page<ApplyShowAll> findAllByCompanyId(Pageable page, @Param("idCompany") Long id);

    Page<Apply> findAllByUser_Id(Pageable pageable, Long id);

    boolean existsByUserIdAndRecuitmentNewId(Long userID, Long recuitmentID);

}
