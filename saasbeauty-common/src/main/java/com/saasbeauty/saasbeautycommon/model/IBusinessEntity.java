package com.saasbeauty.saasbeautycommon.model;

public interface IBusinessEntity<ID> {
    ID getId();
    void setId(ID id);

    String getCode();
    void setCode(String code);
}
