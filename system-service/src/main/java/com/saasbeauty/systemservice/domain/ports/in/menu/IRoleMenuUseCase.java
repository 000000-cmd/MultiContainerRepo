package com.saasbeauty.systemservice.domain.ports.in.menu;

import com.saasbeauty.systemservice.domain.model.menu.RoleMenu;

import java.util.List;

public interface IRoleMenuUseCase {

    RoleMenu create(RoleMenu roleMenu);

    List<RoleMenu> getByRoleCode(String roleCode);

    void delete(String id);
}