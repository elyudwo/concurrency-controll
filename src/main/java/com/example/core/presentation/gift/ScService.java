package com.example.core.presentation.gift;


import com.example.core.domain.stock.GiftStock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScService {

    private final GiftService giftService;

    public synchronized GiftStock register() {
        return giftService.callRegister();
    }
}
