package com.example.yangshaomin.weather;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView search;
    EditText edittext;
    TextView tv_city;
    TextView tv_temp;
    TextView tv_weather;
    TextView tv_wind;
    TextView tv_pm;

    //自定义json数据
    String arrayShanghai = "[{\"temp\":\"20C/30C\",\"weather\":\"晴转多云\",\"name\":\"上海\",\"pm\":\"80\",\"wind\":\"1级\"}]";
    String arrayBeijing = "[{\"temp\":\"15C/24C\",\"weather\":\"晴\",\"name\":\"北京\",\"pm\":\"98\",\"wind\":\"3级\"}]";
    String arrayGuangzhou = "[{\"temp\":\"26C/32C\",\"weather\":\"多云\",\"name\":\"广州\",\"pm\":\"30\",\"wind\":\"2级\"}]";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (ImageView) findViewById(R.id.search);
        edittext = (EditText) findViewById(R.id.edittext);
        tv_city = (TextView) findViewById(R.id.tv_city);
        tv_temp = (TextView) findViewById(R.id.tv_temp);
        tv_weather = (TextView) findViewById(R.id.tv_weather);
        tv_wind = (TextView) findViewById(R.id.tv_wind);
        tv_pm = (TextView) findViewById(R.id.tv_pm);
        //点击search
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city=edittext.getText().toString().trim();



                switch (city){


                    case "上海":
                        json(arrayShanghai);
                        break;
                    case "广州":
                        json(arrayGuangzhou);
                        break;
                    case "北京":
                        json(arrayBeijing);
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"不好意思",Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });

    }

    public void passDate(){
        //创建intent对象，启动activity2
        Intent intent=new Intent (this,weatherActivity.class);
        intent.putExtra("city",tv_city.getText().toString().trim());
        intent.putExtra("wearther",tv_weather.getText().toString().trim());
        intent.putExtra("temp",tv_temp.getText().toString().trim());
        intent.putExtra("wind",tv_wind.getText().toString().trim());
        intent.putExtra("pm",tv_pm.getText().toString().trim());
        startActivity(intent);
    }




    //解析json数据
    public void json(String whetherX) {

        try {
            JSONArray array = new JSONArray(whetherX);

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = (JSONObject) array.opt(i);

                String temp = obj.getString("temp");

                String weather2 = obj.getString("weather");

                String name = obj.getString("name");

                String pm = obj.getString("pm");

                String win = obj.getString("wind");
                tv_city.setText(name);
                tv_weather.setText(weather2);
                tv_temp.setText(temp);
                tv_wind.setText(win);
                tv_pm.setText(pm);
                passDate();
            }
        } catch (JSONException e) {

            e.printStackTrace();

        }


    }



}