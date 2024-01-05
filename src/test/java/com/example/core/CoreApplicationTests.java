package com.example.core;

import com.example.core.domain.gift.GiftRepository;
import com.example.core.domain.stock.GiftStock;
import com.example.core.domain.stock.GiftStockRepository;
import com.example.core.presentation.gift.GiftService;
import com.example.core.presentation.gift.ScService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
class CoreApplicationTests {

    @Autowired
    GiftRepository giftRepository;

    @Autowired
    GiftStockRepository giftStockRepository;

    @Autowired
    GiftService giftService;

    @Autowired
    ScService scService;

    @Test
    void Synchronized_사용() throws InterruptedException {
        giftStockRepository.save(GiftStock.builder()
                .giftName("StarBucks")
                .stock(10L)
                .build());

        ExecutorService executorService = Executors.newFixedThreadPool(50);
        CountDownLatch countDownLatch = new CountDownLatch(50);

        AtomicInteger successCount = new AtomicInteger();
        AtomicInteger failCount = new AtomicInteger();

        for (int i = 1; i <= 50; i++) {
            executorService.execute(() -> {
                try {
                    giftService.callRegister();
                    successCount.incrementAndGet();
                } catch (Exception e) {
                    failCount.incrementAndGet();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        System.out.println("successCount = " + successCount);
        System.out.println("failCount = " + failCount);
    }

    @Test
    void contextLoads() {
    }

}
