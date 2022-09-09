package com.techmarcus.dsmeta.services;

import com.techmarcus.dsmeta.entities.Sale;
import com.techmarcus.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FindAllSalesService {

    @Autowired private SaleRepository saleRepository;

    public Page<Sale> findAllSales(String minDate, String maxDate ,Pageable pageable){
        LocalDate today = LocalDate.now();
        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        return saleRepository.findSales(min, max, pageable);
    }
}
