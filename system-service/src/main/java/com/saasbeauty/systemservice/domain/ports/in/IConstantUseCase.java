package com.saasbeauty.systemservice.domain.ports.in;

import com.saasbeauty.systemservice.domain.model.Constant;

public interface IConstantUseCase {
    Constant createConstant(Constant constant);
    Constant updateConstant(Constant constant);
    Constant getByCode(String code);

    void deleteConstant(Constant constant);

    void toggleEnabled(String code, boolean enabled);
    void toggleVisible(String code,  boolean visible);
}
