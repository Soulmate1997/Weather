package com.example.yangshaomin.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class weatherActivity extends AppCompatActivity {

    TextView tv_city;
    TextView tv_temp;
    TextView tv_weather;
    TextView tv_wind;
    TextView tv_pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


        //获取intent对象
        Intent intent=getIntent();
        //取值
        String city=intent.getStringExtra("city");
        String wearther=intent.getStringExtra("wearther");
        String temp=intent.getStringExtra("temp");
        String wind=intent.getStringExtra("wind");
        String pm=intent.getStringExtra("pm");

        tv_city = (TextView) findViewById(R.id.tv_city);
        tv_temp = (TextView) findViewById(R.id.tv_temp);
        tv_weather = (TextView) findViewById(R.id.tv_weather);
        tv_wind = (TextView) findViewById(R.id.tv_wind);
        tv_pm = (TextView) findViewById(R.id.tv_pm);
        //赋值
        tv_city.setText(city);
        tv_temp.setText(temp);
        tv_weather.setText(wearther);
        tv_wind.setText("风："+wind);
        tv_pm.setText("pm:"+pm);


        //activity2被销毁，值返回activity1



}
}
