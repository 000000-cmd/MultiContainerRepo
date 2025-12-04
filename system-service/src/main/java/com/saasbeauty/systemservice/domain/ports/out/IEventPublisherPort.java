package com.saasbeauty.systemservice.domain.ports.out;

import com.saasbeauty.systemservice.domain.model.Constant;

public interface IEventPublisherPort {
    void publishConstantUpdated(Constant constant);
}
