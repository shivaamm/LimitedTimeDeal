package com.example.limited_time_deal;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DealService {

    private final Map<Long, Deal> dealStore = new HashMap<>();
    private final Map<Long, Map<String,Boolean>> dealClaims = new HashMap<>();

    private long dealCounter = 0;

    public Deal createDeal(double price, int quantity, LocalDateTime startTime, LocalDateTime endTime) {
        Deal deal = new Deal(dealCounter++, price, quantity, startTime, endTime);
        dealStore.put(deal.getId(), deal);
        dealClaims.put(deal.getId(), new HashMap<>());
        return deal;
    }

    public Optional<Deal> endDeal(Long dealId){
        Deal deal = dealStore.get(dealId);
        if(deal!=null){
            deal.setEndTime(LocalDateTime.now());
            return Optional.of(deal);
        }
        return Optional.empty();
    }

    public Optional<Deal> updateDeal(Long dealId, Integer additonalQuantity, LocalDateTime newEndTime){
        Deal deal = dealStore.get(dealId);
        if(deal!=null){
            if(additonalQuantity!=null) {
                deal.setQuantity(deal.getQuantity() + additonalQuantity);
                deal.setAvailableQuantity(deal.getAvailableQuantity() + additonalQuantity);
            }

            if(newEndTime!=null){
                deal.setEndTime(newEndTime);
            }
            return Optional.of(deal);
        }
        return Optional.empty();
    }

    public String claimDeal(Long dealId, String userId){
        Deal deal = dealStore.get(dealId);
        if(deal!=null){
            Map<String, Boolean> userClaims = dealClaims.get(dealId);
            if(userClaims.containsKey(userId)){
                return "User already claimed the deal";
            }
            if(deal.getAvailableQuantity()>0 && deal.getQuantity()>0){
                deal.setAvailableQuantity(deal.getAvailableQuantity()-1);
                userClaims.put(userId, true);
                return "Deal claimed successfully";
            }
            return "Deal out of stock";
        }
        return "Deal not found";


    }


}
