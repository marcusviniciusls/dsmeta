package com.techmarcus.dsmeta.controllers;

import com.techmarcus.dsmeta.entities.Sale;
import com.techmarcus.dsmeta.services.FindAllSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

    @Autowired private FindAllSalesService findAllSalesService;

    @GetMapping
    public List<Sale> findAllSales(){
        return findAllSalesService.findAllSales();
    }
}
