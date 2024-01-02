package com.btb.transactionservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyOrderDTO {

    private String symbol;

    private String side = "BUY";

    private String market = "MARKET";

    private Double quantity;

}
