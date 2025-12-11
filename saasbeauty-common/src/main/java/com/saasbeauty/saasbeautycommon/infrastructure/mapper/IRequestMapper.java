package com.saasbeauty.saasbeautycommon.infrastructure.mapper;

public interface IRequestMapper<D, R> {
    D toDomain(R request);
}
