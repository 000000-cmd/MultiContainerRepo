package com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.mapper.menu;

import com.saasbeauty.saasbeautycommon.infrastructure.mapper.IBaseMapper;
import com.saasbeauty.systemservice.domain.model.menu.Menu;
import com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.entity.menu.MenuEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MenuPersistenceMapper extends IBaseMapper<Menu, MenuEntity> {
}
