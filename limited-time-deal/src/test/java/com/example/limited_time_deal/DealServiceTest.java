package com.example.limited_time_deal;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class DealServiceTest {

    private DealService dealService;


    public DealServiceTest() {
        dealService = new DealService();
    }

    @Test
    public void testCreateDeal() {

        LocalDateTime startTime = LocalDateTime.of(2021, 1, 1, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2021, 1, 2, 0, 0);

        // create a deal
        Deal deal = dealService.createDeal(100, 3, startTime, endTime);
        assertNotNull(deal);
        assertEquals(100, deal.getPrice());
        assertEquals(3, deal.getQuantity());
        assertEquals(0, deal.getAvailableQuantity());
        assertEquals(startTime, deal.getStartTime());
        assertEquals(endTime, deal.getEndTime());

        //claim deal
        String claimResult = dealService.claimDeal(deal.getId(), "user1");
//        assertEquals("Deal out of stock", claimResult);
//        assertEquals(0, deal.getAvailableQuantity());

        // update deal
//        LocalDateTime newEndTime = LocalDateTime.of(2021, 1, 3, 0, 0);
//        Optional<Deal> updatedDeal = dealService.updateDeal(deal.getId(), 5, newEndTime);
//        assertNotNull(updatedDeal);
//        assertEquals(15, updatedDeal.get().getQuantity());
//        assertEquals(5, updatedDeal.get().getAvailableQuantity());
//        assertEquals(newEndTime, updatedDeal.get().getEndTime());

        //claim deal
        claimResult = dealService.claimDeal(deal.getId(), "user1");
//        assertEquals("Deal claimed successfully", claimResult);
//        assertEquals(4, deal.getAvailableQuantity());
        claimResult = dealService.claimDeal(deal.getId(), "user1");
        claimResult = dealService.claimDeal(deal.getId(), "user3");
        claimResult = dealService.claimDeal(deal.getId(), "user4");
//        claimResult = dealService.claimDeal(deal.getId(), "user1");

        // end deal
        Optional<Deal> endedDeal = dealService.endDeal(deal.getId());
        assertNotNull(endedDeal);
//        assertTrue(endedDeal.get().getEndTime().isBefore(LocalDateTime.of(2021, 1, 2, 0, 0)));
    }

}
