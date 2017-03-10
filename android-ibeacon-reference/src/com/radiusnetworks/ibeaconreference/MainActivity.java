package com.radiusnetworks.ibeaconreference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.radiusnetworks.ibeacon.IBeaconManager;

import android.R.layout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.StaticLayout;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



/**
 * 
 * @author sqp && echosun
 * 
 */
public class MainActivity extends Activity {
	public static String sr;
	public Button room7501,room7502,room7503,room7509,room7606,room7701,room7705;
	protected static final String TAG = "MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "oncreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		verifyBluetooth();
		
		roomListener();
	}
	
    private void roomListener(){
    	room7501=(Button) findViewById(R.id.room7501);
		room7502=(Button) findViewById(R.id.room7502);
		room7503=(Button) findViewById(R.id.room7503);
		room7509=(Button) findViewById(R.id.room7509);
		room7606=(Button) findViewById(R.id.room7606);
		room7701=(Button) findViewById(R.id.room7701);
		room7705=(Button) findViewById(R.id.room7705);
		
        room7501.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//String sr=DBLink.sendGet("http://10.30.19.139:8081/IbeaconServer/Query", "GetURL=1");
				Intent intent=new Intent(MainActivity.this,Guide.class);
				startActivity(intent);
				DBLinkThread a=new DBLinkThread();
				a.start();
				
			}
		});
		
        room7502.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Guide.class);
				//startActivity(intent);
				TextView temp=(TextView) findViewById(R.id.location);
				temp.setText(sr);
			}
		});
        
         room7503.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Guide.class);
				startActivity(intent);
			}
		});
         
         room7509.setOnClickListener(new OnClickListener() {
 			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Guide.class);
				startActivity(intent);
			}
		});
         
         room7606.setOnClickListener(new OnClickListener() {
 			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Guide.class);
				startActivity(intent);
			}
		});
         
         room7701.setOnClickListener(new OnClickListener() {
 			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Guide.class);
				startActivity(intent);
			}
		});
         
         room7705.setOnClickListener(new OnClickListener() {
 			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,Guide.class);
				startActivity(intent);
			}
		});
        
    	
    }
	private void verifyBluetooth() {

		try {
			if (!IBeaconManager.getInstanceForApplication(this).checkAvailability()) {
				final AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("蓝牙不可用！");
				builder.setMessage("请开启蓝牙并重启app！");
				builder.setPositiveButton(android.R.string.ok, null);
				builder.setOnDismissListener(new DialogInterface.OnDismissListener() {

					@Override
					public void onDismiss(DialogInterface dialog) {
						finish();
						System.exit(0);
					}

				});
				builder.show();

			}
		} catch (RuntimeException e) {
			final AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Bluetooth LE not available");
			builder.setMessage("Sorry, this device does not support Bluetooth LE.");
			builder.setPositiveButton(android.R.string.ok, null);
			builder.setOnDismissListener(new DialogInterface.OnDismissListener() {

				@Override
				public void onDismiss(DialogInterface dialog) {
					finish();
					System.exit(0);
				}

			});
			builder.show();

		}

	}

}
