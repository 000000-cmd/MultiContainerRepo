package com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.mapper;

import com.saasbeauty.systemservice.domain.model.Constant;
import com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.entity.ConstantEntity;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public class ConstantPersistenceMapper {

    public ConstantEntity toConstantEntity(Constant constant) {
        if (constant == null) return null;

        ConstantEntity entity = new ConstantEntity();

        if (constant.getId() != null) {
            entity.setId(UUID.fromString(constant.getId()));
        }
        entity.setCode(constant.getCode());
        entity.setValue(constant.getValue());
        entity.setDescription(constant.getDescription());
        entity.setVisible(constant.isVisible());
        entity.setEnabled(constant.isEnabled());
        return entity;
    }

    public Constant toDomain(ConstantEntity entity) {
        if (entity == null) return null;

        Constant constant = new Constant();
        constant.setId(entity.getId().toString());
        constant.setCode(entity.getCode());
        constant.setValue(entity.getValue());
        constant.setDescription(entity.getDescription());
        constant.setVisible(entity.isVisible());
        constant.setEnabled(entity.isEnabled());
        return constant;
    }

}
