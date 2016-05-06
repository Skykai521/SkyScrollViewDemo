package com.boohee.scrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private RelativeLayout relativeLayout;
    private Button button;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        button = (Button) findViewById(R.id.btn);
        relativeLayout = (RelativeLayout) findViewById(R.id.rl_content);
        scrollView.setOverScrollMode(View.OVER_SCROLL_ALWAYS);

//        Reflect.on(scrollView).set("mOverscrollDistance", 60);
        //https://github.com/tianzhijiexian/Android-Best-Practices/blob/master/2015.9/reflect/reflect.md
        Reflect.on(scrollView).set("mOverflingDistance", 100);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fling(5000);
                Log.d(TAG, "scrollView height : " + scrollView.getHeight() + " rl height : " + relativeLayout.getHeight());
            }
        });
    }

}
