package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.dto.request.SearchJob;
import com.codegym.finalproject.model.dto.response.RecuitmentNewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class IRecuimentNewDAOImpl implements IRecuitmentnewDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    @Override
    public List<RecuitmentNewDTO> findJob(SearchJob searchJob) {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("produces")
                .returningResultSet("recuitmentnew", (RowMapper<RecuitmentNewDTO>) (rs, rowNum) -> {
                    RecuitmentNewDTO recuitmentNewDTO = new RecuitmentNewDTO();
                    recuitmentNewDTO.setId(rs.getLong("id"));
                    recuitmentNewDTO.setTitle(rs.getString("title"));
                    recuitmentNewDTO.setDescription(rs.getString("description"));
                    recuitmentNewDTO.setStatus(rs.getString("status"));
                    recuitmentNewDTO.setCompanyId(rs.getLong("companyId"));
                    recuitmentNewDTO.setCityId(rs.getLong("cityId"));
                    recuitmentNewDTO.setCityName(rs.getString("cityName"));
                    recuitmentNewDTO.setCompanyName(rs.getString("companyName"));
                    recuitmentNewDTO.setFieldId(rs.getLong("fieldId"));
                    recuitmentNewDTO.setFieldName(rs.getString("fieldName"));
                    recuitmentNewDTO.setVacanciesId(rs.getLong("vacanciesId"));
                    recuitmentNewDTO.setVacanciesName(rs.getString("vacanciesName"));
                    recuitmentNewDTO.setWorkingTimeId(rs.getLong("workingTimeId"));
                    recuitmentNewDTO.setWorkingTimeName(rs.getString("workingTimeName"));
                    recuitmentNewDTO.setAvatar(rs.getString("avatar"));
                    recuitmentNewDTO.setSalary(rs.getInt("salary"));
                    recuitmentNewDTO.setExpDate(rs.getString("expDate"));
                    return recuitmentNewDTO;
                });
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("title", searchJob.getTitle())
                .addValue("cityId", searchJob.getCityId())
                .addValue("fieldId", searchJob.getFieldId())
                .addValue("companyId", searchJob.getCompanyId())
                .addValue("vacancies", searchJob.getVacancies())
                .addValue("workingTimeId", searchJob.getWorkingTimeId())
                .addValue("start", searchJob.getStart())
                .addValue("page_size", searchJob.getPageSize())
                .addValue("salary", searchJob.getSalary());
        Map out = simpleJdbcCall.execute(in);
        return (List<RecuitmentNewDTO>) out.get("recuitmentnew");
    }
}
