package com.saasbeauty.systemservice.domain.ports.out;

import com.saasbeauty.saasbeautycommon.model.BaseDomain;
import com.saasbeauty.saasbeautycommon.model.IBusinessEntity;
import java.util.List;
import java.util.Optional;

// T = modelo de dominio (ej: Role, Constant)
// ID = El tipo de ID (ej: UUID o String)
public interface IGenericRepositoryPort<T extends BaseDomain & IBusinessEntity<ID>, ID> {

    T save(T entity);

    T update(T entity);

    List<T> findAll();

    Optional<T> findById(ID id);

    Optional<T> findByCode(String code);

    void deleteById(ID id);

    boolean existsByCode(String code);

    boolean existsById(ID id);
}