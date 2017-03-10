package com.radiusnetworks.ibeaconreference;

import java.util.ArrayList;
import java.util.Collection;

import android.R.layout;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconConsumer;
import com.radiusnetworks.ibeacon.IBeaconManager;
import com.radiusnetworks.ibeacon.MonitorNotifier;
import com.radiusnetworks.ibeacon.RangeNotifier;
import com.radiusnetworks.ibeacon.Region;

public class Guide extends Activity implements IBeaconConsumer {
	protected static final String TAG = "MonitoringActivity";
	private BeaconAdapter adapter = null;
	private ArrayList<IBeacon> arrayL = new ArrayList<IBeacon>();
	private LayoutInflater inflater;
	private BeaconServiceUtility beaconUtill = null;
	private IBeaconManager iBeaconManager = IBeaconManager.getInstanceForApplication(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		x=0.0;
		y=0.0;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guide);
		beaconUtill = new BeaconServiceUtility(this);
		adapter = new BeaconAdapter();
		inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		addRadioButton("É³ÅÌ",300,600,2333,true);
		addRadioButton("µ¹Á¢°Ú",600,600,23333,false);
		

	}
	private double x;
	private double y;
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
	}

	@Override
	protected void onStart() {
		super.onStart();
		beaconUtill.onStart(iBeaconManager, this);
	}

	@Override
	protected void onStop() {
		beaconUtill.onStop(iBeaconManager, this);
		super.onStop();
	}

	@Override
	public void onIBeaconServiceConnect() {

		iBeaconManager.setRangeNotifier(new RangeNotifier() {
			@Override
			public void didRangeBeaconsInRegion(Collection<IBeacon> iBeacons, Region region) {

				arrayL.clear();
				arrayL.addAll((ArrayList<IBeacon>) iBeacons);
				adapter.notifyDataSetChanged();
			}

		});

		iBeaconManager.setMonitorNotifier(new MonitorNotifier() {
			@Override
			public void didEnterRegion(Region region) {
				Log.e("BeaconDetactorService", "didEnterRegion");
				// logStatus("I just saw an iBeacon for the first time!");
			}

			@Override
			public void didExitRegion(Region region) {
				Log.e("BeaconDetactorService", "didExitRegion");
				// logStatus("I no longer see an iBeacon");
			}

			@Override
			public void didDetermineStateForRegion(int state, Region region) {
				Log.e("BeaconDetactorService", "didDetermineStateForRegion");
				// logStatus("I have just switched from seeing/not seeing iBeacons: " + state);
			}

		});

		try {
			iBeaconManager.startRangingBeaconsInRegion(new Region("myRangingUniqueId", null, null, null));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		try {
			iBeaconManager.startMonitoringBeaconsInRegion(new Region("myMonitoringUniqueId", null, null, null));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private class BeaconAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			if (arrayL != null && arrayL.size() > 0)
				return arrayL.size();
			else
				return 0;
		}

		@Override
		public IBeacon getItem(int arg0) {
			return arrayL.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return convertView;
		}
	}
	
	public void addRadioButton(String name,float x,float y,int id,final Boolean checked){
		
		RelativeLayout rl;
		rl=(RelativeLayout) findViewById(R.id.plan);
		RadioButton rb = new RadioButton(this);
		rb.setId(id);
	    rb.setText(name); 
	    rb.setTextColor(0xFF0000FF);
	    rb.setX((float) x);
	    rb.setY((float) y);
	    rb.setChecked(checked);
		rl.addView(rb);
//		new Thread(){
//		    public void run(){
//		    	RelativeLayout rl=(RelativeLayout) findViewById(R.id.plan);
//		    	RadioButton rb =(RadioButton)rl.findViewById(2333);	    
//			    rb.setX((float) x);
//			    rb.setY((float) y);
//			    x+=50;y+=50;
//		    } 
//		}.start();
	    rb.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(checked){
					startWebView();	
				}
				
			}
		});
	    
	}

	public void startWebView(){
		Intent intent=new Intent(Guide.this,Web.class);
		startActivity(intent);
	}

}