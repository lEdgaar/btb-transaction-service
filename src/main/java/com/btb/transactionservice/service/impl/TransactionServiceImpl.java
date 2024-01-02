package com.btb.transactionservice.service.impl;

import com.btb.transactionservice.client.BinanceServiceClient;
import com.btb.transactionservice.dto.BuyOrderDTO;
import com.btb.transactionservice.dto.SellOrderDTO;
import com.btb.transactionservice.service.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Log4j2
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private BinanceServiceClient binanceServiceClient;

    @Override
    public void buyOrder(BuyOrderDTO buyOrderDTO) {
        log.info("Event: Buy order");

        binanceServiceClient.createOrder(buyOrderDTO);
    }

    @Override
    public void sellOrder(SellOrderDTO sellOrderDTO) {
        log.info("Event: Sell order");

        binanceServiceClient.sellOrder(sellOrderDTO);
    }

}
