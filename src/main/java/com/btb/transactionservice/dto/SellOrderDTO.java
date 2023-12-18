package com.btb.transactionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellOrderDTO {

    private long userId;

    private long assetId;

    private double priceUnit;

    private long quantity;

}
