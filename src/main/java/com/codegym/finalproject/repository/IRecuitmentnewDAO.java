package com.codegym.finalproject.repository;

import com.codegym.finalproject.model.dto.request.SearchJob;
import com.codegym.finalproject.model.dto.response.RecuitmentNewDTO;

import java.util.List;

public interface IRecuitmentnewDAO {
    List<RecuitmentNewDTO> findJob(SearchJob searchJob);
}
