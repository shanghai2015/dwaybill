package com.daphne.dwaybill.http.request;

public class WayBillInformationRequest extends Request{

    private String preBillNo;

    public String getPreBillNo() {
        return preBillNo;
    }

    public void setPreBillNo(String preBillNo) {
        this.preBillNo = preBillNo;
    }

}
