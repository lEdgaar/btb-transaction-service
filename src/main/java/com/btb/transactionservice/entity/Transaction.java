package com.btb.transactionservice.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private long id;

    private Date createdAt;

    private long transactionType;

    private long quantity;

    private long assetId;

    private double priceUnit;

    private long userId;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
