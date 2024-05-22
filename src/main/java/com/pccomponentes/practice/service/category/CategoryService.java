package com.pccomponentes.practice.service.category;

import com.pccomponentes.practice.dto.CategoryActionDTO;
import com.pccomponentes.practice.mapper.CategoryActionMapper;
import com.pccomponentes.practice.repository.CategoryActionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements iCategoryService {

    @Autowired
    CategoryActionRepo categoryActionRepo;

    @Override
    public List<CategoryActionDTO> findAllCategoryAction() {
        return CategoryActionMapper.mapToCategoryActionDTOList(categoryActionRepo.findAll());
    }

}