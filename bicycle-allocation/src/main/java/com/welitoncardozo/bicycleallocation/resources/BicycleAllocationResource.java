package com.welitoncardozo.bicycleallocation.resources;

import com.welitoncardozo.bicycleallocation.dtos.BicycleAllocationDto;
import com.welitoncardozo.bicycleallocation.dtos.BicycleAllocationInput;
import com.welitoncardozo.bicycleallocation.enums.AllocationStatus;
import com.welitoncardozo.bicycleallocation.services.BicycleAllocationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
public class BicycleAllocationResource {
    private final BicycleAllocationService bicycleAllocationService;

    @PostMapping
    public void save(@Valid @RequestBody final BicycleAllocationInput input) {
        bicycleAllocationService.save(input);
    }

    @GetMapping
    public List<BicycleAllocationDto> list(@RequestParam(required = false) final Long bicycle, @RequestParam(required = false) final Long client) {
        return bicycleAllocationService.findAll(bicycle, client)
                .stream()
                .map(BicycleAllocationDto::from)
                .toList();
    }

    @GetMapping("/historic")
    public List<BicycleAllocationDto> listHistoric(
            @RequestParam(required = false) final Long bicycle,
            @RequestParam(required = false) final Long client,
            @RequestParam(required = false) final AllocationStatus status
    ) {
        return bicycleAllocationService.findAllHistoric(bicycle, client, status)
                .stream()
                .map(BicycleAllocationDto::from)
                .toList();
    }
}
