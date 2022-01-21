package com.hdi.corretor.service;

import java.util.HashMap;

import com.hdi.corretor.model.Broker;

import org.springframework.stereotype.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class BrokerService {            

    public static RestTemplate client = new RestTemplate();    

    
    public Broker getBroker(String baseUrl){
        ResponseEntity<Broker> entity = client.getForEntity(baseUrl + "/broker", Broker.class);
        return entity.getBody();    
    }

    public Broker getBroker(String baseUrl, String document){
        ResponseEntity<Broker> entity = client.getForEntity(baseUrl + "/broker/" + document, Broker.class);
        return entity.getBody();
    }         

    public Broker postBroker(String baseUrl, Broker broker){        
        ResponseEntity<Broker> entity = client.postForEntity(baseUrl + "/broker", broker, Broker.class);        
        return entity.getBody();    
    } 

    public void putBroker(String baseUrl, String status, String code){   
        HashMap<String, Object> request = new HashMap<>();
        request.put("active", status);
        client.put(baseUrl + "/broker/" + code, request);        
    } 

    public void deleteBrokerData(String baseUrl, String code){                
        client.delete(baseUrl + "/broker/" + code);        
    } 

}
