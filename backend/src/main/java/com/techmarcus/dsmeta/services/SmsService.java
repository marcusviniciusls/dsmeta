package com.techmarcus.dsmeta.services;

import com.techmarcus.dsmeta.entities.Sale;
import com.techmarcus.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired private SaleRepository saleRepository;

    public void sendSms(Long id) {
        Sale sale = saleRepository.findById(id).get();
        String date = sale.getDate().getMonth() + "/" + sale.getDate().getYear();
        String msg = "O Vendedor " + sale.getSellerName() + " Foi destaque em " + date + "Com o total de R$ " +
                String.format("%.2f", sale.getAmount());

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, msg).create();

        System.out.println(message.getSid());
    }
}
