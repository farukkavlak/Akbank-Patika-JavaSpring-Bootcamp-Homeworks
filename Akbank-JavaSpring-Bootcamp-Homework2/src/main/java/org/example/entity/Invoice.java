package org.example.entity;/*
Created by farukkavlak on 29.05.2023
@author: farukkavlak
@date: 29.05.2023
@project: Akbank-JavaSpring-Bootcamp-Homework2
*/

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Invoice {
    private static final AtomicInteger IdBuilder = new AtomicInteger(0);
    private final Long id;
    private Long customerId;
    private Long companyId;
    private Double amount;
    private Date created_at;

    public Invoice(Double amount, Long customerId, Long companyId) {
        this.id = (long) IdBuilder.incrementAndGet();
        this.amount = amount;
        //Random date between june 2023 and july 2023
        this.created_at = new Date((long) (Math.random() * (7953600000L) + 1622505600000L));
        this.customerId = customerId;
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", companyId=" + companyId +
                ", amount=" + amount +
                ", created_at=" + created_at +
                '}';
    }

}
