package com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.mapper;

import com.saasbeauty.saasbeautycommon.infrastructure.mapper.IBaseMapper;
import com.saasbeauty.systemservice.domain.model.Constant;
import com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.entity.ConstantEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConstantPersistenceMapper extends IBaseMapper<Constant, ConstantEntity> {
}