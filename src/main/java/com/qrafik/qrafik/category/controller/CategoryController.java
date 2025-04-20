package com.qrafik.qrafik.category.controller;

import com.qrafik.qrafik.category.dto.request.CategoryCreateRequest;
import com.qrafik.qrafik.category.dto.response.CategoryResponse;
import com.qrafik.qrafik.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryCreateRequest categoryCreateRequest) {
        CategoryResponse categoryResponse = categoryService.createCategory(categoryCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

    @GetMapping("/workplaces/{workplaceId}")
    public ResponseEntity<List<CategoryResponse>> getAllCategoriesByWorkplaceId(@PathVariable Long workplaceId) {
        List<CategoryResponse> categoryResponseList = categoryService.getAllCategoriesByWorkplaceId(workplaceId);
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponseList);
    }
}
