package com.saasbeauty.systemservice.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateConstantRequest {
    private String code;
    private String value;
    private String description;
    private boolean enabled;
    private boolean visible;
}
