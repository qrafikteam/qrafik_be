package com.qrafik.qrafik.category.service;

import com.qrafik.qrafik.category.dto.request.CategoryCreateRequest;
import com.qrafik.qrafik.category.dto.response.CategoryResponse;
import com.qrafik.qrafik.category.entity.Category;
import com.qrafik.qrafik.category.repository.CategoryRepository;
import com.qrafik.qrafik.workplace.entity.Workplace;
import com.qrafik.qrafik.workplace.service.WorkplaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final WorkplaceService workplaceService;

    public CategoryResponse createCategory(CategoryCreateRequest categoryCreateRequest) {
        Workplace workplace = workplaceService.findById(categoryCreateRequest.getWorkplaceId());

        Category category = Category.builder()
                .name(categoryCreateRequest.getName())
                .description(categoryCreateRequest.getDescription())
                .workplace(workplace)
                .build();

        category = categoryRepository.save(category);

        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public List<CategoryResponse> getAllCategoriesByWorkplaceId(Long workplaceId) {
        List<Category> categories = categoryRepository.findAllByWorkplace_Id(workplaceId);

        return categories.stream()
                .map(category -> CategoryResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .toList();
    }
}
