package com.daphne.dwaybill.http.response;

public class Response {
    private String returnDate;
    private Integer returnCode;
    private String returnMsg;
    private String returnData;
    private Integer returnTotalRecords;

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    public Integer getReturnTotalRecords() {
        return returnTotalRecords;
    }

    public void setReturnTotalRecords(Integer returnTotalRecords) {
        this.returnTotalRecords = returnTotalRecords;
    }

    @Override
    public String toString() {
        return "Response{" +
                "returnDate='" + returnDate + '\'' +
                ", returnCode=" + returnCode +
                ", returnMsg='" + returnMsg + '\'' +
                ", returnData='" + returnData + '\'' +
                ", returnTotalRecords=" + returnTotalRecords +
                '}';
    }
}
