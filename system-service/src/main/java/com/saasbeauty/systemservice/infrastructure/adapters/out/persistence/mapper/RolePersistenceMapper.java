package com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.mapper;

import com.saasbeauty.saasbeautycommon.infrastructure.mapper.IBaseMapper;
import com.saasbeauty.systemservice.domain.model.lists.Role;
import com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.entity.lists.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolePersistenceMapper extends IBaseMapper<Role, RoleEntity> {
}
