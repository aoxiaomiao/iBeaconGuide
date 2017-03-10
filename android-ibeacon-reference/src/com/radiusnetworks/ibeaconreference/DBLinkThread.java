package com.radiusnetworks.ibeaconreference;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class DBLinkThread extends Thread{
	public void run(){
		MainActivity.sr=link("Getall", "7501");
	}
	public String link(String cmd,String id){

		String path = "http://10.30.19.139:8081/IbeaconServer/Query?"+cmd+"="+id;
		// �½�HttpGet����
		HttpGet httpGet = new HttpGet(path);
		// ��ȡHttpClient����
		HttpClient httpClient = new DefaultHttpClient();
		// ��ȡHttpResponseʵ��
		HttpResponse httpResp = null;
		try {
			httpResp = httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			// ��ȡ���ص�����
		String result = null;
		try {
			result = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		//Log.i(TAG_HTTPGET, "HttpGet��ʽ����ɹ��������������£�");
		//Log.i(TAG_HTTPGET, result);
	}
}