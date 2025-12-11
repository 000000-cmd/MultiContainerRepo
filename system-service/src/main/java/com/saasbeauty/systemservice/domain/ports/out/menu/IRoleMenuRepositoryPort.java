package com.saasbeauty.systemservice.domain.ports.out.menu;

import com.saasbeauty.systemservice.domain.model.menu.RoleMenu;

import java.util.List;

public interface IRoleMenuRepositoryPort {

    RoleMenu save(RoleMenu roleMenu);

    void deleteById(String id);

    RoleMenu findById(String id);

    List<RoleMenu> findByRoleCode(String roleCode);

    boolean existsByRoleAndMenu(String roleId, String menuId);
}
