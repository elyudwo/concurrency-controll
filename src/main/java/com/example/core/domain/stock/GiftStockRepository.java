package com.example.core.domain.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftStockRepository extends JpaRepository<GiftStock, Long> {

    GiftStock findByGiftName(String name);
}
