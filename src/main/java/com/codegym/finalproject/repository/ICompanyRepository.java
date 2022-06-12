package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.dto.response.CompanyRecruitmentNeed;
import com.codegym.finalproject.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findAllByAccount_Id(Long id);
    Boolean existsByName(String name);

    @Query(value = "select c.* from company c where c.status_company = :stt limit 3;",nativeQuery = true)
    List<Company> findCompanyByStatus(@Param("stt") Integer stt);

    @Query(value = "select c.id as id,c.avatar as avatar,c.name as name, count(r.id) as count from company c join recuitmentnew r on c.id = r.company_id group by c.id order by count DESC limit 3;", nativeQuery = true)
    List<CompanyRecruitmentNeed> findCompanyByRecuitmentNew();

}
