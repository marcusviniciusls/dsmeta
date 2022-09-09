package com.techmarcus.dsmeta.services;

import com.techmarcus.dsmeta.entities.Sale;
import com.techmarcus.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllSalesService {

    @Autowired private SaleRepository saleRepository;

    public List<Sale> findAllSales(){
        return saleRepository.findAll();
    }
}
