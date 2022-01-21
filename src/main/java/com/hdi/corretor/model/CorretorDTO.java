package com.hdi.corretor.model;

import java.text.SimpleDateFormat;

public class CorretorDTO {
    
    private String nome;
    private String documento;
    private String codigo;    
    private String dataCriacao;
    private String taxaComissao;
    private boolean flagAtivo;

    public CorretorDTO(Broker pBrocker, BrokerData pBrockerData) {        
        this.nome = pBrocker.getName();
        this.documento = pBrocker.getDocument();
        this.codigo = pBrocker.getCode();    
        this.taxaComissao = pBrockerData.getCommissionRate();
        this.flagAtivo = pBrockerData.getActive();
        //formata dataCriacao
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        dataCriacao = format.format(pBrocker.getCreateDate());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(String taxaComissao) {
        this.taxaComissao = taxaComissao;
    }

    public boolean isFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

}
