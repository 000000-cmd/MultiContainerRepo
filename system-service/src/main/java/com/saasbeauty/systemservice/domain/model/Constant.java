package com.saasbeauty.systemservice.domain.model;

import com.saasbeauty.saasbeautycommon.model.BaseDomain;
import com.saasbeauty.saasbeautycommon.model.IBusinessEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Constant extends BaseDomain implements IBusinessEntity<String> {
    private String id;
    private String code;
    private String value;
    private String description;
}
