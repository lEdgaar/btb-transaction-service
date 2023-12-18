package com.btb.transactionservice.service.impl;

import com.btb.transactionservice.dto.BuyOrderDTO;
import com.btb.transactionservice.dto.SellOrderDTO;
import com.btb.transactionservice.entity.Transaction;
import com.btb.transactionservice.md.TransactionTypeMD;
import com.btb.transactionservice.persistence.mapper.TransactionMapper;
import com.btb.transactionservice.service.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Log4j2
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public void buyOrder(BuyOrderDTO buyOrderDTO) {
        log.trace("Event: Buy order: user: {}, assetId: {}", buyOrderDTO.getUserId(), buyOrderDTO.getAssetId());

        Transaction transaction = new Transaction();
        // TODO comprobar usuario
        transaction.setUserId(buyOrderDTO.getUserId());
        // TODO comprobar activo
        transaction.setAssetId(buyOrderDTO.getAssetId());
        transaction.setQuantity(buyOrderDTO.getQuantity());
        // TODO Comprobar precio y delay del mismo
        transaction.setPriceUnit(buyOrderDTO.getPriceUnit());
        transaction.setCreatedAt(new Date());
        transaction.setTransactionType(TransactionTypeMD.BUY.id());

        transactionMapper.save(transaction);
        log.trace("Transaction saved for userId: {}", transaction.getUserId());
    }

    @Override
    public void sellOrder(SellOrderDTO sellOrderDTO) {
        log.trace("Event: Sell order: user: {}, assetId: {}", sellOrderDTO.getUserId(), sellOrderDTO.getAssetId());

        Transaction transaction = new Transaction();
        // TODO comprobar usuario
        transaction.setUserId(sellOrderDTO.getUserId());
        // TODO comprobar activo
        transaction.setAssetId(sellOrderDTO.getAssetId());
        transaction.setQuantity(sellOrderDTO.getQuantity());
        // TODO Comprobar precio y delay del mismo
        transaction.setPriceUnit(sellOrderDTO.getPriceUnit());
        transaction.setCreatedAt(new Date());
        transaction.setTransactionType(TransactionTypeMD.SELL.id());

        transactionMapper.save(transaction);

    }

}
