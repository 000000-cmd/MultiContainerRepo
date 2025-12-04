package com.saasbeauty.systemservice.application.mappers;

import com.saasbeauty.systemservice.application.dto.request.CreateConstantRequest;
import com.saasbeauty.systemservice.domain.model.Constant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConstantApplicationMapper {
    Constant toModel(CreateConstantRequest constant);
}
