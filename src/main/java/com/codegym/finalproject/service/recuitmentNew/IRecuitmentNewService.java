package com.codegym.finalproject.service.recuitmentNew;

import com.codegym.finalproject.model.dto.request.SearchJob;
import com.codegym.finalproject.model.entity.RecuitmentNew;
import com.codegym.finalproject.service.IGeneralService;

import java.util.List;

public interface IRecuitmentNewService extends IGeneralService<RecuitmentNew> {
    //    Tìm kiếm Job theo ngành nghề, địa chỉ
    List<RecuitmentNew> searchByField(SearchJob searchJob);

    List<RecuitmentNew> findAllByCompany_Id(Long id);

    List<RecuitmentNew> search(SearchJob searchJob);
}
