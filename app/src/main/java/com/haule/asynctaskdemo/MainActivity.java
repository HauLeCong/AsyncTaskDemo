package com.haule.asynctaskdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.haule.asynctaskdemo.action.CallApi;

public class MainActivity extends AppCompatActivity implements Callback {
    @Override
    public void onTaskCompleted(String data) {
        //show data to view
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String url = "https://api.stackexchange.com/2.2/questions?order=desc&sort=activity&site=stackoverflow";
        new CallApi( this).execute(url);
    }
}
