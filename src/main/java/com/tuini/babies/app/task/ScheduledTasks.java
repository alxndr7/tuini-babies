package com.tuini.babies.app.task;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tuini.babies.app.controller.ProductoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private ProductoController productoController;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 5000)
    @Scheduled(cron = "0 0 4,8,12 * * *", zone = "America/Bogota" )
    public void reportCurrentTime() throws IOException {
        log.info("The time is now {}", dateFormat.format(new Date()));
        productoController.getJobDiario12M();
    }
}