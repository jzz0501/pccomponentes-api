package com.pccomponentes.practice.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pageable<T> {

    private Integer currentPage;

    private Integer totalPage;

    private Long totalItem;

    private String nextPageURL;

    private String prevPageURL;

    private List<T> items;

}
