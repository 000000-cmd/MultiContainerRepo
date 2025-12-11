package com.saasbeauty.systemservice.application.services.lists;

import com.saasbeauty.systemservice.application.services.GenericCrudService;
import com.saasbeauty.systemservice.domain.model.lists.Role;
import com.saasbeauty.systemservice.domain.ports.in.lists.IRoleUseCase;
import com.saasbeauty.systemservice.domain.ports.out.lists.IRoleRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericCrudService<Role, String> implements IRoleUseCase {


    public RoleService(IRoleRepositoryPort repository) {
        super(repository);
    }

}
