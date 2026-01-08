package com.saasbeauty.systemservice.application.services;

import com.saasbeauty.saasbeautycommon.domain.exceptions.BusinessException;
import com.saasbeauty.systemservice.domain.model.Constant;
import com.saasbeauty.systemservice.domain.ports.in.IConstantUseCase;
import com.saasbeauty.systemservice.domain.ports.out.IConstantRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ConstantService extends GenericCrudService<Constant, String> implements IConstantUseCase {

    public ConstantService(IConstantRepositoryPort repository) {
        super(repository);
    }
}
