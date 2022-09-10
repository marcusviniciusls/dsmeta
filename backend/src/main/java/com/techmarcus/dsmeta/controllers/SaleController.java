package com.techmarcus.dsmeta.controllers;

import com.techmarcus.dsmeta.entities.Sale;
import com.techmarcus.dsmeta.services.FindAllSalesService;
import com.techmarcus.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

    @Autowired private FindAllSalesService findAllSalesService;
    @Autowired private SmsService smsService;

    @GetMapping
    public Page<Sale> findAllSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable){
        return findAllSalesService.findAllSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id){
        smsService.sendSms(id);
    }
}
