package org.example.service;/*
Created by farukkavlak on 29.05.2023
@author: farukkavlak
@date: 29.05.2023
@project: Akbank-JavaSpring-Bootcamp-Homework2
*/

import org.example.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final List<Customer> customerList = new ArrayList<>();
    private void initCustomerList() {
        for (int i = 0; i < 10; i++) {
            this.save("Customer" + i);
        }
    }
    public CustomerService() {
        initCustomerList();
    }
    public Customer save(String name) {
        Customer customer = new Customer(name);
        customerList.add(customer);
        return customer;
    }
    public Customer findById(Long id) {
        return customerList.stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Customer> findAll() {
        return customerList;
    }

    public List<Customer> findByNameInclude(String searchText) {
        return customerList.stream().filter(customer -> customer.getName().contains(searchText)).toList();
    }
    public List<String> findAllByMaxAmountInvoice(Double minAmount) {
        return customerList.stream().filter(customer -> customer.getInvoiceList().stream().anyMatch(invoice -> invoice.getAmount() > minAmount)).map(Customer::getName).toList();
    }

    public Double sumOfInvoicesByMonthOfCustomer(Integer month) {
        return customerList.stream().filter(customer -> customer.getCreated_at().getMonth() == month).mapToDouble(customer -> customer.getInvoiceList().stream().mapToDouble(invoice -> invoice.getAmount()).sum()).sum();
    }



}
