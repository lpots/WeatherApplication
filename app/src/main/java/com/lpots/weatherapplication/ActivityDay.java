package com.lpots.weatherapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityDay extends AppCompatActivity {

    ListView lvMain;
    ArrayList<DayWeather> hours = new ArrayList<DayWeather>();
    DayAdapter dayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        // создаем адаптер
        fillData();
        dayAdapter = new DayAdapter(this, hours);

        // настраиваем список
        lvMain = (ListView) findViewById(R.id.hours);
        lvMain.setAdapter(dayAdapter);
    }

    void fillData() {
        hours.add(new DayWeather("00:00", "Пасмурно", R.mipmap.ic_launcher, 8, 60 ));
        hours.add(new DayWeather("03:00", "Пасмурно", R.mipmap.ic_launcher, 5, 65 ));
        hours.add(new DayWeather("06:00", "Пасмурно", R.mipmap.ic_launcher, 5, 70 ));
        hours.add(new DayWeather("09:00", "Солнечно", R.mipmap.ic_launcher, 9, 50 ));
        hours.add(new DayWeather("12:00", "Солнечно", R.mipmap.ic_launcher, 18, 55 ));
        hours.add(new DayWeather("15:00", "Пасмурно", R.mipmap.ic_launcher, 22, 60 ));
        hours.add(new DayWeather("18:00", "Дождь", R.mipmap.ic_launcher, 15, 85 ));
        hours.add(new DayWeather("21:00", "Дождь", R.mipmap.ic_launcher, 13, 90 ));
    }
}
