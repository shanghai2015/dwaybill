package com.daphne.dwaybill.service;

import com.daphne.dwaybill.http.request.Request;
import com.daphne.dwaybill.http.response.Response;

public interface WaybillApiService {
    Response createExpWaybill(Request request);

    Response getWayBillInformation(String preBillNo);


}
