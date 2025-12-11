package com.saasbeauty.systemservice.domain.model;

import com.saasbeauty.saasbeautycommon.model.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Constant extends BaseDomain {
    private String id;
    private String code;
    private String value;
    private String description;

}
