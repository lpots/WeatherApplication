package com.lpots.weatherapplication;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CityAdapter extends BaseAdapter{
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<CityWeather> objects;

    CityAdapter(Context context, ArrayList<CityWeather> days) {
        ctx = context;
        objects = days;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.day_item, parent, false);
        }

        CityWeather p = getDay(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.tvDate)).setText(p.date);
        ((TextView) view.findViewById(R.id.tvDescription)).setText(p.description);
        ((ImageView) view.findViewById(R.id.ivImage)).setImageResource(p.img);
        ((TextView) view.findViewById(R.id.tvAvgTemp)).setText(p.avgTemp +"");
        ((TextView) view.findViewById(R.id.tvDayNightTemp)).setText(p.dayTemp + " C" + "/" + p.nightTemp + " C");

        return view;
    }

    // получить день
    CityWeather getDay(int position) {
        return ((CityWeather) getItem(position));
    }
}
