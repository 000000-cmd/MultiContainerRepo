package com.saasbeauty.systemservice.domain.model.menu;

import com.saasbeauty.saasbeautycommon.model.BaseDomain;
import com.saasbeauty.saasbeautycommon.model.IBusinessEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleMenu extends BaseDomain {

    private String id;

    private String roleId;
    private String menuId;

    private String roleCode;
    private String menuCode;
}
