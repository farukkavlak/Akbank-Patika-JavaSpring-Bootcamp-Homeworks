package org.example;


import org.example.service.CompanyService;
import org.example.service.CustomerService;
import org.example.service.InvoiceService;

public class Main {
    private static final CustomerService customerService = new CustomerService();
    private static final CompanyService companyService = new CompanyService();
    private static final InvoiceService invoiceService = new InvoiceService(customerService, companyService);

    public static void main(String[] args) {
        System.out.println("All Customers");
        System.out.println(customerService.findAll());
        System.out.println("-----------------------------");
        System.out.println("All Customers that name includes 'C'");
        System.out.println(customerService.findByNameInclude("C"));
        System.out.println("-----------------------------");
        System.out.println("Total amount of invoices by customers registered in June(6th month)");
        System.out.println(customerService.sumOfInvoicesByMonthOfCustomer(6));
        System.out.println("-----------------------------");
        System.out.println("All Invoices");
        System.out.println(invoiceService.findAll());
        System.out.println("-----------------------------");
        System.out.println("All Invoices that amount is greater than 1500.0");
        System.out.println(invoiceService.findAllByMinAmount(1500.0));
        System.out.println("-----------------------------");
        System.out.println("Average of all invoices that amount is greater than 1500.0");
        System.out.println(invoiceService.calculateAverageOfInvoicesByMinAmount(1500.0));
        System.out.println("-----------------------------");
        System.out.println("Names of customers that at least one of the invoices amount is less than 500.0");
        System.out.println(customerService.findAllByMaxAmountInvoice(500.0));
        System.out.println("-----------------------------");
        System.out.println("Sector of companies in which the average invoices for the month of June are less than 750");
        System.out.println(companyService.findSectorsByMaxAmountInvoice(750.0));
    }
}