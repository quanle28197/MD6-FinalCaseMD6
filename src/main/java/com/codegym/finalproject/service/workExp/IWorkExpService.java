package com.codegym.finalproject.service.workExp;

import com.codegym.finalproject.model.entity.WorkExp;
import com.codegym.finalproject.service.IGeneralService;


public interface IWorkExpService extends IGeneralService<WorkExp> {
    Iterable<WorkExp> findAllByCv_Id(Long id);

    Boolean existByCv_Id(Long id);
}
