package com.example.loadingdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;

public class MainActivity extends Activity {

	private ProgressDialog dialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dialog = new ProgressDialog(this);
		dialog.setTitle("Now Loading");
		dialog.setMessage("Please wait...");
		dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		dialog.show();

		Thread thread = new Thread(new Waiting());
		thread.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private class Waiting implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(3000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			handler.sendEmptyMessage(0);
		}
	}
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO 自動生成されたメソッド・スタブ
			super.handleMessage(msg);
			dialog.dismiss();
		}

	};
}
