package com.btb.transactionservice.md;

public enum TransactionTypeMD {
    BUY (1L, "Buy"),
    SELL(2L, "Sell"),
    REJECTED(3L, "Rejected");

    private Long id;

    private String name;

    TransactionTypeMD(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long id() {
        return this.id;
    }
}
