package com.lpots.weatherapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMain;

    String[] sCities = {"Пенза"};
    ArrayList<CityWeather> days = new ArrayList<CityWeather>();
    CityAdapter cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // для спиннера
        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sCities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // получаем спиннер и устанавливаем ему адаптер
        Spinner spinner = (Spinner) findViewById(R.id.cities);
        spinner.setAdapter(adapter);

        // для listView
        // создаем адаптер
        fillData();
        cityAdapter = new CityAdapter(this, days);

        // настраиваем список
        lvMain = (ListView) findViewById(R.id.days);
        lvMain.setAdapter(cityAdapter);

        // обработчик
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, ActivityDay.class);
                startActivity(intent);
            }
        });
    }

    void fillData() {
        days.add(new CityWeather("Пенза", "Пасмурно", "13.05", R.mipmap.ic_launcher, 15, 23, 8 ));
        days.add(new CityWeather("Пенза", "Солнечно", "14.05", R.mipmap.ic_launcher, 20, 30, 13 ));
        days.add(new CityWeather("Пенза", "Солнечно", "15.05", R.mipmap.ic_launcher, 21, 31, 15 ));
        days.add(new CityWeather("Пенза", "Дождь", "16.05", R.mipmap.ic_launcher, 10, 15, 5 ));
        days.add(new CityWeather("Пенза", "Пасмурно", "17.05", R.mipmap.ic_launcher, 13, 20, 10 ));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
