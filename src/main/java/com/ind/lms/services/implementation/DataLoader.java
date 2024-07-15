package com.ind.lms.services.implementation;

import com.ind.lms.repository.interfaces.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.InjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final IUserRepository iUserRepository;

    @Override
    public void run(String... args) throws Exception {
        iUserRepository.findAll().forEach(user ->
                log.debug("User - {}", user)
        );
    }
}
