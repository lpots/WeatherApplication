package com.lpots.weatherapplication;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DayAdapter extends BaseAdapter{
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<DayWeather> objects;

    DayAdapter(Context context, ArrayList<DayWeather> hours) {
        ctx = context;
        objects = hours;
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
            view = lInflater.inflate(R.layout.hour_item, parent, false);
        }

        DayWeather p = getHour(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.tvHour)).setText(p.time);
        ((TextView) view.findViewById(R.id.tvDescription2)).setText(p.description);
        ((ImageView) view.findViewById(R.id.ivImage2)).setImageResource(p.img);
        ((TextView) view.findViewById(R.id.tvTemp)).setText(p.temp +" С");
        ((TextView) view.findViewById(R.id.tvWet)).setText(p.wet +"%");

        return view;
    }

    // получить час
    DayWeather getHour(int position) {
        return ((DayWeather) getItem(position));
    }


}
