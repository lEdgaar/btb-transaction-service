package com.btb.transactionservice.service;

import com.btb.transactionservice.dto.BuyOrderDTO;
import com.btb.transactionservice.dto.SellOrderDTO;

public interface TransactionService {

    void buyOrder(BuyOrderDTO buyOrderDTO);

    void sellOrder(SellOrderDTO sellOrderDTO);

}
