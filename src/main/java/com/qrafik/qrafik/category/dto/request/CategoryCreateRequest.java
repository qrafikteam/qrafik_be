package com.qrafik.qrafik.category.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateRequest {

    private String name;

    private String description;

    private Long workplaceId;
}
