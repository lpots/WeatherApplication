package com.lpots.weatherapplication;

public class DayWeather {
    String time;
    String description;
    int img;
    int temp;
    int wet;

    DayWeather(String _time, String _description, int _img, int _temp, int _wet){
        time = _time;
        description = _description;
        img = _img;
        temp = _temp;
        wet = _wet;
    }
}
