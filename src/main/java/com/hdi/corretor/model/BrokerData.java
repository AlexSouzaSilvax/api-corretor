package com.hdi.corretor.model;

public class BrokerData {
    
    private String code;
    private Boolean active;
    private String commissionRate;
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String getCommissionRate() {
        return commissionRate;
    }
    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate;
    }

    
}
