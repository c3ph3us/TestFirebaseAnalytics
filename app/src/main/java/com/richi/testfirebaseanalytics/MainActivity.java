package com.richi.testfirebaseanalytics;

import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        findViewById(R.id.btnMyBox1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseOptions options = new FirebaseOptions.Builder()
//                        .setApplicationId("1:881835738524:android:faca0b5e10e211e8")
//                        .setApiKey("AIzaSyBGQKuy0kav7VGSRLDK5ZMzjjJyQDxfoNo")
//                        .setDatabaseUrl("test")
//                        .build();
//
////                FirebaseAnalytics.getInstance(MainActivity.this.getApplicationContext()).de
//                FirebaseApp.initializeApp(MainActivity.this.getApplicationContext(), options);
//            }
//        });

//        findViewById(R.id.btnMyBox2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FirebaseOptions options = new FirebaseOptions.Builder()
//                        .setApplicationId("1:217007617222:android:faca0b5e10e211e8")
//                        .setApiKey("AIzaSyB3uiu6NCpxn9KjeGvFdKCblXdE-aokW0o")
//                        .setDatabaseUrl("test")
//                        .build();
//
//                FirebaseApp.initializeApp(MainActivity.this.getApplicationContext(), options);
////                FirebaseApp.getInstance().
//            }
//        });
       

        findViewById(pl.ceph3us.base.common.R.id.btnLog).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View view) {
				new Runnable() {
					@Override
					public void run() {
						// check is initialized 
						if(isDefaultFirebaseAppInitialized()) {
							com.google.firebase.analytics.FirebaseAnalytics.getInstance(view.getContext()).logEvent("ScreenName", new android.os.Bundle());
						} else {
							// log app not ready 
							// get logger log 
							view.postDelayed(this,3000);
						}
					}
				}.run();
			}
		});
        
    }
    
       protected boolean isDefaultFirebaseAppInitialized() {
        try {
            // try get
            return FirebaseApp.getInstance(FirebaseApp.DEFAULT_APP_NAME) != null;
            // catch illegal state exc
        } catch (IllegalStateException ise) {
            // on such case not initialized
            return false;
        }
    }
}
