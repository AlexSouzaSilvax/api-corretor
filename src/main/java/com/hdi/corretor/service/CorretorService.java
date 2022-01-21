package com.hdi.corretor.service;

import com.hdi.corretor.model.Broker;
import com.hdi.corretor.model.BrokerData;
import com.hdi.corretor.model.CorretorDTO;

import org.springframework.stereotype.Service;

@Service
public class CorretorService {  
    
    public CorretorDTO buscaCorretor(String baseUrl, String document) {        
        Broker broker = new BrokerService().getBroker(baseUrl, document);            
        BrokerData brokerData = new BrokerDataService().getBrokerData(baseUrl, broker.getCode());
        return new CorretorDTO(broker, brokerData);
    }

    public String alteraStatusCorretor(String baseUrl, String document, Boolean novoStatus) {                        
        CorretorDTO corretorDTO = buscaCorretor(baseUrl, document);        
        if(corretorDTO.isFlagAtivo() == novoStatus) {
            return "O Status do corretor: " + corretorDTO.getNome() + " já está " + corretorDTO.isFlagAtivo();
        } else {
            BrokerDataService brokerData = new BrokerDataService();
            brokerData.putBrokerData(baseUrl, novoStatus, corretorDTO.getCodigo());            
            return "Status alterado com sucesso!";
        }
    }

}
