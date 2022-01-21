package com.hdi.corretor.service;

import java.util.HashMap;
import com.hdi.corretor.model.BrokerData;

import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Service
public class BrokerDataService {            

    public static RestTemplate client = new RestTemplate();            
    
    public BrokerData getBrokerData(String baseUrl){
        ResponseEntity<BrokerData> entity = client.getForEntity(baseUrl + "/brokerData", BrokerData.class);
        return entity.getBody();    
    }

    public BrokerData getBrokerData(String baseUrl, String code){
        ResponseEntity<BrokerData> entity = client.getForEntity(baseUrl + "/brokerData/" + code, BrokerData.class);
        return entity.getBody();    
    }

    public BrokerData postBrokerData(String baseUrl, BrokerData brokerData){        
        ResponseEntity<BrokerData> entity = client.postForEntity(baseUrl + "/brokerData", brokerData, BrokerData.class);        
        return entity.getBody();    
    } 

    public void putBrokerData(String baseUrl, Boolean status, String code){   
        HashMap<String, Object> request = new HashMap<>();
        request.put("active", status);
        client.put(baseUrl + "/brokerData/" + code, request);        
    } 

    public void deleteBrokerData(String baseUrl, String code){                
        client.delete(baseUrl + "/brokerData/" + code);        
    } 

}
