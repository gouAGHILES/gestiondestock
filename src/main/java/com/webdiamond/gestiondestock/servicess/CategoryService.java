package com.webdiamond.gestiondestock.servicess;

import com.webdiamond.gestiondestock.dto.ArticleDto;
import com.webdiamond.gestiondestock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Integer id);

    CategoryDto findByCodeCategory(String codeCategory);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
