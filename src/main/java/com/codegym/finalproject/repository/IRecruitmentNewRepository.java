package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.entity.RecuitmentNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecruitmentNewRepository extends JpaRepository<RecuitmentNew, Long> {
    List<RecuitmentNew> findAllByCompany_Id(Long id);

    @Query(value = "SELECT COUNT(r) FROM RecuitmentNew r where (:title IS NULL or (r.title like CONCAT('%',:title,'%') or r.company.name like CONCAT('%',:title,'%') or r.city.name like CONCAT('%',:title,'%')))" +
            " and (:cityId is null or r.city.id = :cityId)" +
            " and (:fieldId is null or r.field.id = :fieldId)" +
            " and (:companyId is null or r.company.id = :companyId)" +
            " and (:vacancies is null or r.vacancies.id = :vacancies)" +
            " and (:workingTimeId is null or r.workingTime.id = :workingTimeId) and (r.salary >= :salary or :salary IS NULL)" +
            " and r.status = TRUE and r.company.account.status <> 'LOCK'")
    Long countTotalRecords(@Param("title") String title,
                           @Param("cityId") Long cityId,
                           @Param("fieldId") Long fieldId,
                           @Param("companyId") Long companyId,
                           @Param("vacancies") Long vacancies,
                           @Param("workingTimeId") Long workingTimeId,
                           @Param("salary") Integer salary);

    //  Tìm kiếm job theo công ty và thành phố
    @Query("SELECT r FROM RecuitmentNew r" +
            " LEFT JOIN Company c ON r.company.id = c.id" +
            " LEFT JOIN City ci ON r.city.id = ci.id" +
            " WHERE lower(r.title) LIKE lower(CONCAT('%', :title, '%'))" +
            " OR LOWER(c.name) LIKE LOWER(CONCAT('%', :title, '%'))" +
            " OR LOWER(ci.name) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<RecuitmentNew> search(@Param("title") String title);

    // Tìm kiếm Job theo ngành nghề, địa chỉ
    @Query("SELECT r FROM RecuitmentNew r " +
            "left join Field f on r.field.id = f.id " +
            "left join City ci on r.city.id = ci.id " +
            "WHERE lower(r.title) like lower(concat('%', :title, '%')) " +
            "or LOWER(ci.name) like lower(concat('%', :title, '%')) " +
            "or lower(f.name) like lower(concat('%', :title, '%'))")
    List<RecuitmentNew> searchByField(@Param("title") String title);
}
