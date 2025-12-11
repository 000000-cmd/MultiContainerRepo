package com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.entity;

import com.saasbeauty.saasbeautycommon.persistence.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "constants")
@Data
public class ConstantEntity extends BaseEntity {
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
}
