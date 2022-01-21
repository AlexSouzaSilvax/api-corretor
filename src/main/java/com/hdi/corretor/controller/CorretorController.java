package com.hdi.corretor.controller;

import com.hdi.corretor.model.CorretorDTO;
import com.hdi.corretor.service.CorretorService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/corretor")
public class CorretorController {

    @Value("${baseUrl}")
	private String baseUrl;

    @GetMapping("/{document}")
    public ResponseEntity<Object> validaCorretor(@PathVariable String document) throws Exception {
        CorretorDTO corretorDTO = new CorretorService().buscaCorretor(baseUrl, document);
        if(corretorDTO.isFlagAtivo()) {
            return ResponseEntity.ok(corretorDTO);
        } else {    
            return ResponseEntity.ok().body("O corretor " + corretorDTO.getNome() + " está inativo.");
        }
    }

    @GetMapping("/{document}/altera-status/{status}")
    public ResponseEntity<Object> alteraStatusCorretor(@PathVariable String document, @PathVariable Boolean status) throws Exception {
        return ResponseEntity.ok().body(new CorretorService().alteraStatusCorretor(baseUrl, document, status));
    }

}