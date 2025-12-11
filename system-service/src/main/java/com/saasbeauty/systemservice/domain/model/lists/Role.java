package com.saasbeauty.systemservice.domain.model.lists;

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
public class Role extends BaseDomain implements IBusinessEntity<String> {

    private String id;
    private String code;
    private String name;
    private String description;
}