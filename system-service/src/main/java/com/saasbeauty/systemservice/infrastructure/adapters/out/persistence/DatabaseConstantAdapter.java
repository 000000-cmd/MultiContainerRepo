package com.saasbeauty.systemservice.infrastructure.adapters.out.persistence;

import com.saasbeauty.systemservice.domain.model.Constant;
import com.saasbeauty.systemservice.domain.ports.out.IConstantRepositoryPort;
import com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.entity.ConstantEntity;
import com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.mapper.ConstantPersistenceMapper;
import com.saasbeauty.systemservice.infrastructure.adapters.out.persistence.repository.JpaConstantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DatabaseConstantAdapter implements IConstantRepositoryPort {

    private final JpaConstantRepository jpaConstantRepository;
    private final ConstantPersistenceMapper constantPersistenceMapper;

    @Override
    public Constant saveConstant(Constant constant) {
        ConstantEntity entity = constantPersistenceMapper.toConstantEntity(constant);
        ConstantEntity saved = jpaConstantRepository.save(entity);
        return constantPersistenceMapper.toDomain(saved);
    }

    @Override
    public Constant updateConstant(Constant constant){
        ConstantEntity entity = constantPersistenceMapper.toConstantEntity(constant);
        ConstantEntity updated = jpaConstantRepository.updateConstant(entity);
        return  constantPersistenceMapper.toDomain(updated);
    }

    @Override
    public Constant findByCode(String code) {
        return jpaConstantRepository.findByCode(code)
                .map(constantPersistenceMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void deleteConstant(Constant constant) {
        if (constant.getId() != null) {
            jpaConstantRepository.deleteById(UUID.fromString(constant.getId()));
        }
    }

    @Override
    public boolean existById(String id) {
        return jpaConstantRepository.existsById(UUID.fromString(id));
    }

    @Override
    public boolean existByCode(String code) {
        return jpaConstantRepository.existsByCode(code);
    }

    @Override
    @Transactional
    public void updateEnabled(String id, boolean enabled) {
        if (id != null) {
            jpaConstantRepository.updateEnabledStatus(UUID.fromString(id), enabled);
        }
    }

    @Override
    @Transactional
    public void updateVisible(String id, boolean visible) {
        if (id != null) {
            jpaConstantRepository.updateVisibleStatus(UUID.fromString(id), visible);
        }
    }
}
