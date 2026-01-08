package com.saasbeauty.systemservice.domain.ports.out;

import com.saasbeauty.systemservice.domain.model.Constant;

public interface IConstantRepositoryPort extends IGenericRepositoryPort<Constant, String> {

    void updateEnabled(String id, boolean enabled);
}
