package com.qrafik.qrafik.workplace.controller;

import com.qrafik.qrafik.workplace.dto.request.WorkplaceCreateRequest;
import com.qrafik.qrafik.workplace.dto.response.WorkplaceResponse;
import com.qrafik.qrafik.workplace.service.WorkplaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/workplaces")
@RequiredArgsConstructor
public class WorkplaceController {

    private final WorkplaceService workplaceService;

    @PostMapping
    public ResponseEntity<WorkplaceResponse> create(@RequestBody WorkplaceCreateRequest workplaceCreateRequest) {
        WorkplaceResponse workplaceResponse = workplaceService.createWorkplace(workplaceCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(workplaceResponse);
    }
}
