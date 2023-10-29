package com.webdiamond.gestiondestock.servicess.impl;

import com.webdiamond.gestiondestock.dto.CategoryDto;
import com.webdiamond.gestiondestock.exception.EntityNotFoundException;
import com.webdiamond.gestiondestock.exception.ErrorCodes;
import com.webdiamond.gestiondestock.exception.InvalidEntityException;
import com.webdiamond.gestiondestock.model.Category;
import com.webdiamond.gestiondestock.repository.CategoryRepository;
import com.webdiamond.gestiondestock.servicess.CategoryService;
import com.webdiamond.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl( CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Category is not valid");
            throw new InvalidEntityException("la category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(dto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id == null){
            log.error("Category id is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Category avec l'id = "+id+"n'est trouvé dans la bd",
                        ErrorCodes.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public CategoryDto findByCodeCategory(String codeCategory) {
        if(StringUtils.hasLength(codeCategory)){
            log.error("Category code is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findCategoryByCode(codeCategory);
        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()->
                new EntityNotFoundException("Aucune Category avec le code = "+codeCategory+"n'est trouvé dans la bd",
                        ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Category id is null");
            return;
        }
        categoryRepository.deleteById(id);
    }
}
