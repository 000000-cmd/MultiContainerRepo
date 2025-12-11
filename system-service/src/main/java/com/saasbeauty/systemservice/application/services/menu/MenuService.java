package com.saasbeauty.systemservice.application.services.menu;

import com.saasbeauty.systemservice.application.services.GenericCrudService;
import com.saasbeauty.systemservice.domain.model.menu.Menu;
import com.saasbeauty.systemservice.domain.ports.in.menu.IMenuUseCase;
import com.saasbeauty.systemservice.domain.ports.out.menu.IMenuRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class MenuService extends GenericCrudService<Menu, String> implements IMenuUseCase {

    public MenuService(IMenuRepositoryPort repository) {
        super(repository);
    }

}
