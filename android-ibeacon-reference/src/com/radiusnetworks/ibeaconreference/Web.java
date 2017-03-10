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
		// 支持javascript
		webSettings.setJavaScriptEnabled(true);

		// 支持使用localStorage(H5页面的支持)
		webSettings.setDomStorageEnabled(true);

		// 支持数据库
		webSettings.setDatabaseEnabled(true);

		// 支持缓存
		webSettings.setAppCacheEnabled(true);
		String appCaceDir = this.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();
		webSettings.setAppCachePath(appCaceDir);

		// 设置可以支持缩放
		webSettings.setUseWideViewPort(true);

		// 扩大比例的缩放
		webSettings.setSupportZoom(true);

		webSettings.setBuiltInZoomControls(true);

		// 隐藏缩放按钮
		webSettings.setDisplayZoomControls(false);

		// 自适应屏幕
		webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webSettings.setLoadWithOverviewMode(true);

		// 隐藏滚动条
		wv.setHorizontalScrollBarEnabled(false);
		wv.setVerticalScrollBarEnabled(false);
		///
		wv.setWebViewClient(new WebViewClient(){

	           @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            // TODO Auto-generated method stub
	               //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
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
