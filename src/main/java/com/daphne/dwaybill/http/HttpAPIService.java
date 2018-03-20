package com.daphne.dwaybill.http;

import com.alibaba.fastjson.JSON;
import com.daphne.dwaybill.http.request.ExpWaybillRequest;
import com.daphne.dwaybill.http.request.Request;
import com.daphne.dwaybill.http.response.Response;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HttpAPIService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${waybill.baseUrl}")
	private String baseUrl;
	@Autowired
	private CloseableHttpClient httpClient;
	@Autowired
	private RequestConfig requestConfig;

	/*public JSONObject post(String url, Object javaObject) {
		HttpPost postRequest = new HttpPost(baseUri.resolve(url));
		postRequest.setConfig(requestConfig);
		postRequest.addHeader("Accept", "application/json");
		postRequest.addHeader("Accept-Encoding", "gzip, deflate");
		
		logger.debug(postRequest.toString());
		logger.debug(JSON.toJSONString(javaObject));
		
		StringEntity strEntity = new StringEntity(JSON.toJSONString(javaObject), "utf-8");
		strEntity.setContentType("application/json");
		postRequest.setEntity(strEntity);

		InputStream stream = null;
		ByteArrayOutputStream os = null;
		JSONObject json = null;
		try {
			CloseableHttpResponse response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() >= 400) {
				postRequest.abort();
				logger.error("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			} else {
				HttpEntity entity = response.getEntity();
				stream = entity.getContent();
				os = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				for (int len; (len = stream.read(buffer)) != -1;)
					os.write(buffer, 0, len);
				os.flush();
				String result = os.toString("utf-8");
				if(result.length()>1000){
					logger.debug(result.substring(1, 999));
				}
				json = JSON.parseObject(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(stream != null){
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return json;
	}
*/

	public static void main(String[] args) {
		/*ExpWaybillRequest javaObject = new ExpWaybillRequest();
		javaObject.setUserCode("C002");
		javaObject.setCompanyCode("002");
		javaObject.setShipper("张三");
		javaObject.setDeliveryTel("18888888866");
		javaObject.setDeliveryAddress("上海市上海市闵行区");
		javaObject.setDeliveryAddressDetail("浦江镇联航路1588号");
		javaObject.setReceiver("李四");
		javaObject.setReceiveTel("17777777777");
		javaObject.setReceiveAddress("江苏省淮安市淮安区");
		javaObject.setReceiveAddressDetail("安徽省合肥市市辖区南京街");
		javaObject.setPayMode("月结");
		javaObject.setCargoName("药品");
		javaObject.setNumber(2);
		javaObject.setRemark("下午1四点前送达");
		javaObject.setCargoNo("00201020380");
		javaObject.setFreightAmount(12.3);
		javaObject.setQuantity(1);
		HttpAPIService service = new HttpAPIService();

		String url = "http://210.16.188.129:24099/api/Waybill/CreateExpWaybill";
		service.post(javaObject,url);*/

		/*Map<String, String> params = new HashMap<>();
		params.put("preBillNo", "180315145334932002");
		params.put("userCode", "C002");
		params.put("companyCode", "002");
		HttpAPIService service = new HttpAPIService();
		String s = service.get(params, "/api/Waybill/GetWayBillInformation");
		System.out.println(s);*/

		Response response = JSON.parseObject(null, Response.class);
		System.out.println(response);

	}

	public String post(Request request,String url){
		URI baseUri = URI.create(baseUrl);
		HttpPost postRequest = new HttpPost(baseUri.resolve(url));
		postRequest.setConfig(requestConfig);
		postRequest.addHeader("Accept", "application/json");
		postRequest.addHeader("Accept-Encoding", "gzip, deflate");
		StringEntity strEntity = new StringEntity(JSON.toJSONString(request), "utf-8");
		strEntity.setContentType("application/json");
		postRequest.setEntity(strEntity);

		CloseableHttpResponse response = null;
		String result = null;
		try {
			response = httpClient.execute(postRequest);
			if (response.getStatusLine().getStatusCode() >= 400) {
				postRequest.abort();
			} else {
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(response!=null){
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public String get(Map<String,String> map, String url){
		//CloseableHttpClient httpClient = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
		URI baseUri = URI.create(baseUrl);
		//封装请求参数
		//String url = "http://210.16.188.129:24099/api/Waybill/GetWayBillInformation";
		List<NameValuePair> params = new ArrayList<>();
		for (Map.Entry<String,String> entry: map.entrySet()){
			params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}

		CloseableHttpResponse httpResponse = null;
		String result = null;
		try {
			//转换为键值对
			String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
			HttpGet httpGet = new HttpGet(baseUri.resolve(url+"?"+str));
			httpGet.setConfig(requestConfig);
			httpResponse = httpClient.execute(httpGet);
			if(httpResponse.getStatusLine().getStatusCode() == 200){
				result = EntityUtils.toString(httpResponse.getEntity());//获得返回的结果
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				httpResponse.close();//释放资源
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	private static void post() {
		CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
		String url = "http://210.16.188.129:24099/api/Waybill/CreateExpWaybill";
		URI baseUri = URI.create(url);
		//配置超时时间
//		RequestConfig requestConfig = RequestConfig.custom().
//				setConnectTimeout(1000).setConnectionRequestTimeout(1000)
//				.setSocketTimeout(1000).setRedirectsEnabled(true).build();
		HttpPost postRequest = new HttpPost(baseUri.resolve(url));
		//postRequest.setConfig(requestConfig);
		postRequest.addHeader("Accept", "application/json");
		postRequest.addHeader("Accept-Encoding", "gzip, deflate");

		ExpWaybillRequest javaObject = new ExpWaybillRequest();
		javaObject.setUserCode("C002");		javaObject.setCompanyCode("002");
		javaObject.setShipper("张三");
		javaObject.setDeliveryTel("18888888888");
		javaObject.setDeliveryAddress("上海市上海市闵行区");
		javaObject.setDeliveryAddressDetail("浦江镇联航路1588号");
		javaObject.setReceiver("李四");
		javaObject.setReceiveTel("17777777777");
		javaObject.setReceiveAddress("江苏省淮安市淮安区");
		javaObject.setReceiveAddressDetail("安徽省合肥市市辖区南京街");
		javaObject.setPayMode("月结");
		javaObject.setCargoName("药品");
		javaObject.setNumber(1);
		javaObject.setRemark("下午1四点前送达");
		javaObject.setCargoNo("00201020381");
		javaObject.setFreightAmount(12.3);
		javaObject.setQuantity(1);
		System.out.println(JSON.toJSONString(javaObject));
		StringEntity strEntity = new StringEntity(JSON.toJSONString(javaObject), "utf-8");
		strEntity.setContentType("application/json");
		postRequest.setEntity(strEntity);

		try {
			CloseableHttpResponse response = httpCilent.execute(postRequest);
			if (response.getStatusLine().getStatusCode() >= 400) {
				postRequest.abort();
			} else {
				String result = EntityUtils.toString(response.getEntity());
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpCilent.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void get() {
		CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.

		//封装请求参数
		String url = "http://210.16.188.129:24099/api/Waybill/GetWayBillInformation";
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("preBillNo", "180315145334932002"));
		params.add(new BasicNameValuePair("userCode", "C002"));
		params.add(new BasicNameValuePair("companyCode", "002"));

		try {
			//转换为键值对
			String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
			System.out.println(str);
			HttpGet httpGet = new HttpGet(url+"?"+str);
			HttpResponse httpResponse = httpCilent.execute(httpGet);
			if(httpResponse.getStatusLine().getStatusCode() == 200){
				String srtResult = EntityUtils.toString(httpResponse.getEntity());//获得返回的结果
				Response response = JSON.parseObject(srtResult, Response.class);
				System.out.println(response.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				httpCilent.close();//释放资源
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}