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
	 * 使用GET访问去访问网络
	 * @param username
	 * @param password
	 * @return 服务器返回的结果
	 */
	public static String loginOfGet(String cmd,String id) {
		String path = "http://10.30.19.139:8081/IbeaconServer/Query?"+cmd+"="+id;
		// 新建HttpGet对象
		HttpGet httpGet = new HttpGet(path);
		// 获取HttpClient对象
		HttpClient httpClient = new DefaultHttpClient();
		// 获取HttpResponse实例
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
	
			// 获取返回的数据
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
		//Log.i(TAG_HTTPGET, "HttpGet方式请求成功，返回数据如下：");
		//Log.i(TAG_HTTPGET, result);
	
	}
}