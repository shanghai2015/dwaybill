package com.daphne.dwaybill.service.impl;

import com.alibaba.fastjson.JSON;
import com.daphne.dwaybill.http.HttpAPIService;
import com.daphne.dwaybill.http.request.Request;
import com.daphne.dwaybill.http.response.Response;
import com.daphne.dwaybill.service.WaybillApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WaybillApiServiceImpl implements WaybillApiService {

    @Autowired
    private HttpAPIService apiService;

    public Response createExpWaybill(Request request) {
        String result = apiService.post(request, "/api/Waybill/CreateExpWaybill");
        return JSON.parseObject(result, Response.class);
    }

    @Override
    public Response getWayBillInformation(String preBillNo) {
        Map<String, String> params = new HashMap<>();
        params.put("preBillNo", preBillNo);
        params.put("userCode", "C002");
        params.put("companyCode", "002");
        String result = apiService.get(params, "/api/Waybill/GetWayBillInformation");
        return  JSON.parseObject(result, Response.class);
    }
}
