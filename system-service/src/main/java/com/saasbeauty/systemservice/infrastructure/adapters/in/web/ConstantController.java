package com.saasbeauty.systemservice.infrastructure.adapters.in.web;

import com.saasbeauty.systemservice.application.dto.request.CreateConstantRequest;
import com.saasbeauty.systemservice.application.mappers.ConstantApplicationMapper;
import com.saasbeauty.systemservice.domain.model.Constant;
import com.saasbeauty.systemservice.domain.ports.in.IConstantUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/system/constants")
@RequiredArgsConstructor
public class ConstantController {

    private final IConstantUseCase constantUseCase;
    private final ConstantApplicationMapper constantMapper;

     @PostMapping
    public ResponseEntity<Constant> createConstant(@RequestBody @Validated CreateConstantRequest constantRequest) {
         Constant constantModel = constantMapper.toDomain(constantRequest);
         Constant createdConstant = constantUseCase.createConstant(constantModel);
         return new ResponseEntity<>(createdConstant, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Constant> getConstantByCode(@PathVariable String code) {
        Constant constant = constantUseCase.getByCode(code);
        return ResponseEntity.ok(constant);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Constant> updateConstant(@PathVariable String code,
                                                   @RequestBody CreateConstantRequest request) {

        Constant constantModel = constantMapper.toDomain(request);
        constantModel.setCode(code);
        Constant updatedConstant = constantUseCase.updateConstant(constantModel);
        return ResponseEntity.ok(updatedConstant);
    }

    @PatchMapping("/{code}/status")
    public ResponseEntity<Void> toggleEnabled(@PathVariable String code,
                                              @RequestParam boolean enabled) {
        constantUseCase.toggleEnabled(code, enabled);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{code}/visibility")
    public ResponseEntity<Void> toggleVisible(@PathVariable String code,
                                              @RequestParam boolean visible) {
        constantUseCase.toggleVisible(code, visible);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteConstant(@PathVariable String code) {
        Constant constant = constantUseCase.getByCode(code);
        constantUseCase.deleteConstant(constant);
        return ResponseEntity.noContent().build();
    }
}
