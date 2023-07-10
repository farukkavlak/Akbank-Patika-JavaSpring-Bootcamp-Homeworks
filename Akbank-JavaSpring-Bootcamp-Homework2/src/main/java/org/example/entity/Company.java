package org.example.entity;/*
Created by farukkavlak on 29.05.2023
@author: farukkavlak
@date: 29.05.2023
@project: Akbank-JavaSpring-Bootcamp-Homework2
*/

import org.example.enums.SectorType;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Company {
    private static final AtomicInteger IdBuilder = new AtomicInteger(0);
    private final Long id ;
    private String name;
    private SectorType sector;
    private final Date created_at;
    private List<Invoice> invoiceList = new ArrayList<>();

    private Map<Customer, List<Invoice>> customerOrderMap = new HashMap<>();

    public Company(String name, SectorType sector) {
        this.id = (long) IdBuilder.incrementAndGet();
        this.name = name;
        this.sector = sector;
        this.created_at = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SectorType getSector() {
        return sector;
    }

    public Map<Customer, List<Invoice>> getCustomerOrderMap() {
        return customerOrderMap;
    }

    public void setCustomerOrderMap(Map<Customer, List<Invoice>> customerOrderMap) {
        this.customerOrderMap = customerOrderMap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSector(SectorType sector) {
        this.sector = sector;
    }

    public void addInvoice(Invoice invoice) {
        this.invoiceList.add(invoice);
    }

    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

}
