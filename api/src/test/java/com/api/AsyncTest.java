package com.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class AsyncTest {

    Logger log = LoggerFactory.getLogger(getClass());

    public int 메소드_완료_3초_필요() {
        log.info("메소드_완료_3초_필요() 실행");
        try {
            sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 3;
    }

    public int 메소드_완료_1초_필요() {
        log.info("메소드_완료_1초_필요() 실행");
        try {
            sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Test
    @DisplayName("Sync-Blocking")
    void test1() {
        long start = System.currentTimeMillis();

        메소드_완료_3초_필요();
        메소드_완료_1초_필요();

        log.info("전체 걸린시간 {}s", MILLISECONDS.toSeconds((System.currentTimeMillis() - start)));
    }

    @Test
    @DisplayName("Sync-NonBlocking")
    void test2() {
        long start = System.currentTimeMillis();

        CompletableFuture<Integer> fut3 = CompletableFuture.supplyAsync(this::메소드_완료_3초_필요);
        while (!fut3.isDone()) {
            if(System.currentTimeMillis()%1000 == 0)
                log.info("fut3 is not finished yet...{}s", MILLISECONDS.toSeconds((System.currentTimeMillis() - start)));
        }
        log.info(String.valueOf(fut3.join()));

        CompletableFuture<Integer> fut1 = CompletableFuture.supplyAsync(this::메소드_완료_1초_필요);
        while (!fut1.isDone()) {
            if(System.currentTimeMillis()%1000 == 0)
                log.info("fut1 is not finished yet...{}s", MILLISECONDS.toSeconds((System.currentTimeMillis() - start)));
        }
        log.info(String.valueOf(fut1.join()));
    }

    @Test
    @DisplayName("Async-NonBlocking")
    void test3() {
        CompletableFuture.supplyAsync(this::메소드_완료_3초_필요)
        .thenApply(res -> {
            log.info("thenAccept: {}", res);
            return res + "s 소요";
        })
        .thenAccept(res -> log.info("thenApply: {}s", res));

        CompletableFuture.supplyAsync(this::메소드_완료_1초_필요)
        .thenApply(res -> {
            log.info("thenAccept: {}", res);
            return res + "s 소요";
        })
        .thenAccept(res -> log.info("thenApply: {}s", res));

        try {
            log.info("5초 대기");
            sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
