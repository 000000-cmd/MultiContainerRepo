package com.saasbeauty.saasbeautycommon.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDomain {
    private boolean enabled;
    private String auditUser;
    private LocalDateTime auditDate;
}