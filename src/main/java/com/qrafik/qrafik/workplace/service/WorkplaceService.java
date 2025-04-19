package com.qrafik.qrafik.workplace.service;

import com.qrafik.qrafik.workplace.dto.request.WorkplaceCreateRequest;
import com.qrafik.qrafik.workplace.dto.response.WorkplaceResponse;
import com.qrafik.qrafik.workplace.entity.Workplace;
import com.qrafik.qrafik.workplace.repository.WorkplaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkplaceService {

    private final WorkplaceRepository workplaceRepository;

    public WorkplaceResponse createWorkplace(WorkplaceCreateRequest workplaceCreateRequest) {

        Workplace workplace = Workplace.builder()
                .name(workplaceCreateRequest.getName())
                .build();

        workplace = workplaceRepository.save(workplace);

        return WorkplaceResponse.builder()
                .id(workplace.getId())
                .name(workplace.getName())
                .build();
    }

    public Workplace findById(Long id) {
        return workplaceRepository.findById(id).orElse(null);
    }
}
