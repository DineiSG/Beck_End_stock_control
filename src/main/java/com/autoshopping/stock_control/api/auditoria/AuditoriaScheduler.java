package com.autoshopping.stock_control.api.auditoria;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AuditoriaScheduler {

    public static void main(String[] args){
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(()->{
            try{
                LiberacaoService.verificarLiberacoes();
            }catch(Exception e){
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.DAYS);
    }
}
