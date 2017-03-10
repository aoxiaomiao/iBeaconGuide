package com.radiusnetworks.ibeaconreference;

import java.security.PrivateKey;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends Activity {
	@Override
	protected void onPause ()
	{
		WebView wv=(WebView) findViewById(R.id.wv);
	    wv.reload ();
	    super.onPause ();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		WebView wv;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		wv=(WebView) findViewById(R.id.wv);
		
		wv.loadUrl("http://zhaohao19961109.h5-legend.com/h5/e2c41f31-ad22-d99c-20a5-445b61af1475.html");
		///
		WebSettings webSettings = wv.getSettings();
		// ֧��javascript
		webSettings.setJavaScriptEnabled(true);

		// ֧��ʹ��localStorage(H5ҳ���֧��)
		webSettings.setDomStorageEnabled(true);

		// ֧�����ݿ�
		webSettings.setDatabaseEnabled(true);

		// ֧�ֻ���
		webSettings.setAppCacheEnabled(true);
		String appCaceDir = this.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
		webSettings.setAppCachePath(appCaceDir);

		// ���ÿ���֧������
		webSettings.setUseWideViewPort(true);

		// �������������
		webSettings.setSupportZoom(true);

		webSettings.setBuiltInZoomControls(true);

		// �������Ű�ť
		webSettings.setDisplayZoomControls(false);

		// ����Ӧ��Ļ
		webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webSettings.setLoadWithOverviewMode(true);

		// ���ع�����
		wv.setHorizontalScrollBarEnabled(false);
		wv.setVerticalScrollBarEnabled(false);
		///
		wv.setWebViewClient(new WebViewClient(){

	           @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            // TODO Auto-generated method stub
	               //����ֵ��true��ʱ�����ȥWebView�򿪣�Ϊfalse����ϵͳ�����������������
	             view.loadUrl(url);
	            return true;
	        }
	           
	       });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.web, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
