package com.pccomponentes.practice.service.category;

import com.pccomponentes.practice.dto.CategoryActionDTO;
import com.pccomponentes.practice.entity.CategoryAction;

import java.util.List;

public interface iCategoryService {

    List<CategoryActionDTO> findAllCategoryAction();

}
