package org.example.service;/*
Created by farukkavlak on 29.05.2023
@author: farukkavlak
@date: 29.05.2023
@project: Akbank-JavaSpring-Bootcamp-Homework2
*/

import org.example.entity.Company;
import org.example.entity.Customer;
import org.example.entity.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InvoiceService {
    private final List<Invoice> invoiceList = new ArrayList<>();
    private final CustomerService customerService;
    private final CompanyService companyService;
    private static final Random random = new Random();

    private void initInvoiceList() {
        for (int i = 0; i < 10; i++) {
            Double amount = random.nextDouble() * 2000;
            Long customerId = (long) random.nextInt(10)+1;
            Long companyId = (long) random.nextInt(10)+1;
            this.save(new Invoice(amount, customerId, companyId));
        }
    }
    public InvoiceService(CustomerService customerService, CompanyService companyService) {
        this.customerService = customerService;
        this.companyService = companyService;
        initInvoiceList();
    }
    public Invoice save(Invoice invoice) {
        Customer customer = customerService.findById(invoice.getCustomerId());
        Company company = companyService.findById(invoice.getCompanyId());
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        if (company == null) {
            throw new RuntimeException("Company not found");
        }
        customer.addInvoice(invoice);
        company.addInvoice(invoice);
        invoiceList.add(invoice);
        return invoice;
    }

    public List<Invoice> findAll() {
        return invoiceList;
    }

    public List<Invoice> findAllByMinAmount(Double minAmount) {
        return invoiceList.stream().filter(invoice -> invoice.getAmount() > minAmount).toList();
    }

    public Double calculateAverageOfInvoicesByMinAmount(Double minAmount) {
        return invoiceList.stream().filter(invoice -> invoice.getAmount() > minAmount).mapToDouble(Invoice::getAmount).average().orElse(0);
    }
}
