package com.saasbeauty.systemservice.application.services;

import com.saasbeauty.saasbeautycommon.domain.exceptions.BusinessException;
import com.saasbeauty.systemservice.domain.model.Constant;
import com.saasbeauty.systemservice.domain.ports.in.IConstantUseCase;
import com.saasbeauty.systemservice.domain.ports.out.IConstantRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ConstantService implements IConstantUseCase {

    private final IConstantRepositoryPort constantRepositoryPort;

    @Override
    @Transactional
    public Constant createConstant(Constant constant){
        if (constantRepositoryPort.existByCode(constant.getCode())){
            throw new BusinessException("La constante ya existe con el código: " + constant.getCode());
        }
        constant.setEnabled(true);
        return constantRepositoryPort.saveConstant(constant);
    }

    @Override
    @Transactional
    public Constant updateConstant(Constant newConstantValue) {
        if (newConstantValue.getId() == null && newConstantValue.getCode() != null) {
            Constant existing = constantRepositoryPort.findByCode(newConstantValue.getCode());
            if (existing != null) {
                newConstantValue.setId(existing.getId());
            } else {
                throw new BusinessException("No se encontró la constante para actualizar.");
            }
        }
        return constantRepositoryPort.updateConstant(newConstantValue);
    }

    @Override
    public Constant getByCode(String code) {
        Constant constant = constantRepositoryPort.findByCode(code);
        if (constant == null) {
            throw new BusinessException("Constante no encontrada: " + code);
        }
        return constant;
    }

    @Override
    public void deleteConstant(Constant constant) {
        constantRepositoryPort.deleteConstant(constant);
    }

    @Override
    @Transactional
    public void toggleEnabled(String code, boolean enabled) {
        Constant constant = getByCode(code);
        constantRepositoryPort.updateEnabled(constant.getId(), enabled);
    }

    @Override
    @Transactional
    public void toggleVisible(String code, boolean visible) {
        Constant constant = getByCode(code);
        constantRepositoryPort.updateVisible(constant.getId(), visible);
    }
}
