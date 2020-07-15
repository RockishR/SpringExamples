package com.epam.test.droolsdemo.controller;

import com.epam.test.droolsdemo.dto.TradingOrder;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/trading")
public class TradingController {

    @Autowired
    private KieSession session;

    @GetMapping
    public String test(){
        return "Trading app test";
    }

    @PostMapping
    public ResponseEntity<TradingOrder> getCommission(@RequestBody TradingOrder tradingOrder,  UriComponentsBuilder builder ){

        session.insert(tradingOrder);
        session.fireAllRules();

        HttpHeaders headers = new HttpHeaders();
        URI uri = builder.path("/trading").build().toUri();
        headers.setLocation(uri);

        System.out.println("############# "+tradingOrder.getCommission());

        return ResponseEntity.created(uri)
                            .headers(headers)
                            .body(tradingOrder);

    }

}

