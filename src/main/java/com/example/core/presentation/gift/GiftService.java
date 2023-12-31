package com.example.core.presentation.gift;

import com.example.core.domain.gift.Gift;
import com.example.core.domain.gift.GiftRepository;
import com.example.core.domain.stock.GiftStock;
import com.example.core.domain.stock.GiftStockRepository;
import com.example.core.dto.request.gift.GiftRequestDto;
import com.example.core.util.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class GiftService {

    private final GiftRepository giftRepository;
    private final GiftStockRepository giftStockRepository;

    public Long requestGift(GiftRequestDto giftRequest) {
        Gift gift = giftRepository.save(giftRequest.toGift());
        return gift.getUserId();
    }

    @Transactional
    public void callRegister() {
        GiftStock giftStock = giftStockRepository.findByGiftName("StarBucks");
        minusStock(giftStock);
        giftRepository.save(Gift.builder()
                .giftName("StarBucks")
                .build());
    }

    private void minusStock(GiftStock giftStock) {
        if(giftStock.getStock() > 0) {
            giftStock.minusStock();
            return;
        }
        throw new IllegalArgumentException("Stock under zero");
    }
}
