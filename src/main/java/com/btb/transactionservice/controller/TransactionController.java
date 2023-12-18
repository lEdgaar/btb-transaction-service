package com.btb.transactionservice.controller;

import com.btb.transactionservice.dto.BuyOrderDTO;
import com.btb.transactionservice.dto.SellOrderDTO;
import com.btb.transactionservice.service.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/buy")
    public void buyOrder(@RequestBody BuyOrderDTO buyOrderDTO) {
        log.trace("POST /transactions/buy user: {}, assetId: {}", buyOrderDTO.getUserId(), buyOrderDTO.getAssetId());

        log.info("Event: Buy order: user: {}, assetId: {}", buyOrderDTO.getUserId(), buyOrderDTO.getAssetId());
        transactionService.buyOrder(buyOrderDTO);
    }

    @PostMapping("/sell")
    public void sellOrder(@RequestBody SellOrderDTO sellOrderDTO) {
        log.trace("POST /transactions/sell user: {}, assetId: {}", sellOrderDTO.getUserId(), sellOrderDTO.getAssetId());

        log.info("Event: Sell order: user: {}, assetId: {}", sellOrderDTO.getUserId(), sellOrderDTO.getAssetId());
        transactionService.sellOrder(sellOrderDTO);
    }

}
