package com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.repository;

import com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.entity.ConstantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface JpaConstantRepository extends JpaRepository<ConstantEntity, UUID> {

    Optional<ConstantEntity> findByCode(String code);

    boolean existsByCode(String code);

    ConstantEntity updateConstant(ConstantEntity constant);

    @Modifying
    @Query("UPDATE ConstantEntity c SET c.Enabled = :enabled WHERE c.Id = :id")
    void updateEnabledStatus(UUID id, boolean enabled);

    @Modifying
    @Query("UPDATE ConstantEntity c SET c.Visible = :visible WHERE c.Id = :id")
    void updateVisibleStatus(UUID id, boolean visible);
}
