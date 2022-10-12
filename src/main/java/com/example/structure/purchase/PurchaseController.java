package com.example.structure.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/purchase/")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping(path = "user/{userId}")
    public Set<Purchase> getPurchases(@PathVariable("userId") Long userId) {
        return purchaseService.getPurchases(userId);
    }

    @PostMapping(path = "user/{userId}")
    public void registerNewPurchase(@RequestBody Purchase purchase,
                                    @PathVariable("userId") Long userId) {
        purchaseService.addNewPurchase(purchase, userId);
    }

    @DeleteMapping(path = "{purchaseId}")
    public void deletePurchase(@PathVariable("purchaseId") Long purchaseId) {
        purchaseService.deletePurchase(purchaseId);
    }

    @PutMapping(path = "{purchaseId}")
    public void updatePurchase(
            @PathVariable("purchaseId") Long purchaseId,
            @RequestBody Purchase purchase) {
        purchaseService.updatePurchase(purchaseId, purchase);
    }

    ;
}
