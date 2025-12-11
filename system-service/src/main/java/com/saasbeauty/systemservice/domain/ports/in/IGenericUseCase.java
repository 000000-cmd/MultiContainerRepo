package com.saasbeauty.systemservice.domain.ports.in;

import com.saasbeauty.saasbeautycommon.model.BaseDomain;
import com.saasbeauty.saasbeautycommon.model.IBusinessEntity;

import java.util.List;

public interface IGenericUseCase<T extends BaseDomain & IBusinessEntity<ID>, ID> {

    T create(T entity);

    T update(T entity);

    T getByCode(String code);

    T getById(ID id);

    List<T> getAll();

    void delete(ID id);

    void toggleEnabled(ID id, boolean enabled);
}