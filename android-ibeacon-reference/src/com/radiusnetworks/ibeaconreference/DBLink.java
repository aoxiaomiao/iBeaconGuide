package com.radiusnetworks.ibeaconreference;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.R.string;

public class DBLink {

	/**
	 * ʹ��GET����ȥ��������
	 * @param username
	 * @param password
	 * @return ���������صĽ��
	 */
	public static String loginOfGet(String cmd,String id) {
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