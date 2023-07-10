package org.example.service;/*
Created by farukkavlak on 29.05.2023
@author: farukkavlak
@date: 29.05.2023
@project: Akbank-JavaSpring-Bootcamp-Homework2
*/

import org.example.entity.Company;
import org.example.enums.SectorType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CompanyService {
    private final List<Company> companyList = new ArrayList<>();
    private static final Random random = new Random();
    private void initCompanyList() {
        for (int i = 0; i < 10; i++) {
            String name = "Company" + i;
            SectorType sector = SectorType.values()[random.nextInt(SectorType.values().length)];
            this.save(name, sector);
        }
    }
    public CompanyService( ) {
        initCompanyList();
    }
    public Company save(String name, SectorType sector) {
        Company company = new Company(name, sector);
        companyList.add(company);
        return company;
    }
    public Company findById(Long id) {
        return companyList.stream().filter(company -> company.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Company> findAll() {
        return companyList;
    }
    public List<SectorType> findSectorsByMaxAmountInvoice(Double maxAmount) {
        //All companies in which the average invoices for the month of June are less than "maxAmount"
        List<SectorType> filteredSectors = companyList.stream()
                .filter(company -> {
                    double averageInvoiceAmount = company.getInvoiceList().stream()
                            .filter(invoice -> invoice.getCreated_at().getMonth() == 6)// Filter invoices for June only
                            .mapToDouble(invoice -> invoice.getAmount())
                            .average()
                            .orElse(1000000.0); // Default value in case there are no invoices for June
                    return averageInvoiceAmount < maxAmount;
                })
                .map(Company::getSector)
                .collect(Collectors.toList());
        return filteredSectors;
    }
}
