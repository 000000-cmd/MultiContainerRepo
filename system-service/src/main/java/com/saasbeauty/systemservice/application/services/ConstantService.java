package com.saasbeauty.systemservice.application.services;

import com.saasbeauty.systemservice.domain.exceptions.BusinessException;
import com.saasbeauty.systemservice.domain.model.Constant;
import com.saasbeauty.systemservice.domain.ports.in.IConstantUseCase;
import com.saasbeauty.systemservice.domain.ports.out.IConstantRepositoryPort;
import com.saasbeauty.systemservice.domain.ports.out.IEventPublisherPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConstantService implements IConstantUseCase {

    private final IConstantRepositoryPort constantRepositoryPort;


    @Override
    public Constant createConstant(Constant constant){
        if (constantRepositoryPort.existById(constant.getId())){
            throw new BusinessException("La constante ya existe: " + constant.getCode());
        }
        constant.setVisible(true);
        constant.setEnabled(true);
        return constantRepositoryPort.saveConstant((constant));
    }

    @Override
    public Constant updateConstant(Constant newConstantValue) {
        if (newConstantValue.getId() == null && newConstantValue.getCode() != null) {
            Constant existing = constantRepositoryPort.findByCode(newConstantValue.getCode());
            if (existing != null) {
                newConstantValue.setId(existing.getId());
            } else {
                throw new BusinessException("No se encontró la constante para actualizar.");
            }
        }
        return constantRepositoryPort.saveConstant(newConstantValue);
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
    public void toggleEnabled(String code, boolean enabled) {
        Constant constant = getByCode(code);
        constantRepositoryPort.updateEnabled(constant.getId(), enabled);
    }

    @Override
    public void toggleVisible(String code, boolean visible) {
        Constant constant = getByCode(code);
        constantRepositoryPort.updateVisible(constant.getId(), visible);
    }


}
