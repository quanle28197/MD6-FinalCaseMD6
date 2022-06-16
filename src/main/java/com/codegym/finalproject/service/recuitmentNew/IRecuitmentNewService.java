package com.codegym.finalproject.service.recuitmentNew;

import com.codegym.finalproject.model.dto.request.SearchJob;
import com.codegym.finalproject.model.dto.response.PageResponse;
import com.codegym.finalproject.model.entity.RecuitmentNew;
import com.codegym.finalproject.service.IGeneralService;

import java.util.List;

public interface IRecuitmentNewService extends IGeneralService<RecuitmentNew> {
    List<RecuitmentNew> findAllByCompany_Id(Long id);

    List<RecuitmentNew> quickSearchByField(SearchJob searchJob);

    //  Tìm kiếm nhanh Job theo địa chỉ
    List<RecuitmentNew> quickSearchByCity(SearchJob searchJob);

    PageResponse searchByObj(SearchJob searchJob);
}
