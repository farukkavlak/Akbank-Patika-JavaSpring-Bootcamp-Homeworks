package org.example.entity;/*
Created by farukkavlak on 29.05.2023
@author: farukkavlak
@date: 29.05.2023
@project: Akbank-JavaSpring-Bootcamp-Homework2
*/

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private static final AtomicInteger IdBuilder = new AtomicInteger(0);
    private final Long id;
    private String name;
    private Date created_at;
    private List<Invoice> invoiceList = new ArrayList<>();

    public Customer(String name) {
        this.id = (long) IdBuilder.incrementAndGet();
        this.name = name;
        //Random date between june 2023 and july 2023
        this.created_at = new Date((long) (Math.random() * (7953600000L) + 1622505600000L));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    public void addInvoice(Invoice invoice) {
        this.invoiceList.add(invoice);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name +
                ", created_at=" + created_at +
                '}';
    }

}
