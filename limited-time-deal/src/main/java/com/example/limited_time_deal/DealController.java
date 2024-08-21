package com.example.limited_time_deal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/deals")
public class DealController {

    @Autowired
    DealService dealService;

    @PostMapping
    public Deal createDeal(@RequestParam double price, @RequestParam int quantity, @RequestParam String startTime, @RequestParam String endTime) {
        return dealService.createDeal(price, quantity, LocalDateTime.parse(startTime), LocalDateTime.parse(endTime));
    }

    @PostMapping("/{dealId}/claim")
    public String claimDeal(@PathVariable Long dealId, @RequestParam String userId) {
        return dealService.claimDeal(dealId, userId);
    }

    @PutMapping("/{dealId}")
    public Optional<Deal> updateDeal(@PathVariable Long dealId, @RequestParam Integer additonalQuantity, @RequestParam String newEndTime) {
        return dealService.updateDeal(dealId, additonalQuantity, newEndTime!=null?LocalDateTime.parse(newEndTime):null );
    }

    @PostMapping("/{dealId}/end")
    public Optional<Deal> endDeal(@PathVariable Long dealId) {
        return dealService.endDeal(dealId);
    }

}
