package com.pccomponentes.practice.mapper;

import com.pccomponentes.practice.dto.CategoryActionDTO;
import com.pccomponentes.practice.entity.CategoryAction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategoryActionMapper {

    public static List<CategoryActionDTO> mapToCategoryActionDTOList(List<CategoryAction> categoryActions) {
        return categoryActions.stream()
            .map(categoryAction ->
                new CategoryActionDTO(
                    categoryAction.getCategory().getId(),
                    categoryAction.getCategory().getName(),
                    categoryAction.getCategory().getSlug(),
                    categoryAction.getCategory().getDescription(),
                    Map.of(
                        "imageURL",categoryAction.getImageURL(),
                        "webURL", categoryAction.getWebURL()
                    )
                ))
            .collect(Collectors.toList());
    }

}
