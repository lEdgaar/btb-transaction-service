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
        transactionService.buyOrder(buyOrderDTO);
    }

    @PostMapping("/sell")
    public void sellOrder(@RequestBody SellOrderDTO sellOrderDTO) {
        transactionService.sellOrder(sellOrderDTO);
    }

}
