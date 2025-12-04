package com.saasbeauty.systemservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Constant {
    private String id;
    private String code;
    private String value;
    private String description;
    private boolean enabled;
    private boolean visible;
}
