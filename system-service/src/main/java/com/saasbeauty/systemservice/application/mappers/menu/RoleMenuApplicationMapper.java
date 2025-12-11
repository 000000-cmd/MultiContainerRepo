package com.saasbeauty.systemservice.application.mappers.menu;

import com.saasbeauty.saasbeautycommon.infrastructure.mapper.IRequestMapper;
import com.saasbeauty.systemservice.application.dto.request.menu.CreateRoleMenuRequest;
import com.saasbeauty.systemservice.domain.model.menu.RoleMenu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMenuApplicationMapper extends IRequestMapper<RoleMenu, CreateRoleMenuRequest> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roleId", ignore = true)
    @Mapping(target = "menuId", ignore = true)
    @Mapping(target = "enabled", constant = "true")
    @Mapping(target = "auditUser", ignore = true)
    @Mapping(target = "auditDate", ignore = true)
    RoleMenu toDomain(CreateRoleMenuRequest request);
}
