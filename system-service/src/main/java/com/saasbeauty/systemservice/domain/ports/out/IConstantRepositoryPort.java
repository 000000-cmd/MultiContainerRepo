package com.saasbeauty.systemservice.domain.ports.out;

import com.saasbeauty.systemservice.domain.model.Constant;

public interface IConstantRepositoryPort {
    Constant saveConstant(Constant constant);
    Constant updateConstant(Constant constant);
    Constant findByCode(String code);
    void deleteConstant(Constant constant);
    boolean existById(String id);
    boolean existByCode(String code);

    void updateEnabled(String id, boolean enabled);
    void updateVisible(String id, boolean visible);
}
