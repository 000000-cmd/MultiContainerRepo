package com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "constants")
@Data
public class ConstantEntity {
    @Id
    @UuidGenerator
    @Column(name = "Id",  unique = true, nullable = false)
    private UUID Id;

    @Column(name = "Code", unique = true, nullable = false)
    private String Code;

    @Column(name = "Value")
    private String Value;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Visible", nullable = false)
    private boolean Visible;

    @Column(name = "Enabled", nullable = false)
    private boolean Enabled;
}
