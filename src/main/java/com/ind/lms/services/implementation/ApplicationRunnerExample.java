package com.ind.lms.services.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
@Profile({"dev","qa"}) // @Profile("!prod)
public class ApplicationRunnerExample implements ApplicationRunner {
    @Value("${greeting}")
    public static String grt;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Welcome to "+ grt);
        log.debug(args.getOptionNames().toString());
        args.getOptionValues("version").toString();
        //args.getOptionValues("alpha").forEach(log::debug);
    }
}
