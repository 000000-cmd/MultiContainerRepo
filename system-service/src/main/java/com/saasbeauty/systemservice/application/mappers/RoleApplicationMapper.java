package com.saasbeauty.systemservice.application.mappers;

import com.saasbeauty.saasbeautycommon.infrastructure.mapper.IRequestMapper;
import com.saasbeauty.systemservice.application.dto.request.CreateRoleRequest;
import com.saasbeauty.systemservice.domain.model.lists.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleApplicationMapper extends IRequestMapper<Role, CreateRoleRequest> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enabled", constant = "true")
    @Mapping(target = "auditUser", ignore = true)
    @Mapping(target = "auditDate", ignore = true)
    Role toDomain(CreateRoleRequest request);
}
