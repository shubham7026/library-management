package com.ind.lms.services.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Profile({"dev","qa"}) // @Profile("!prod)
public class ApplicationRunnerExample implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug(args.getOptionNames().toString());
        if (args.getOptionValues("version") == null ) return;
        args.getOptionValues("version").toString();
        //args.getOptionValues("alpha").forEach(log::debug);
    }
}
