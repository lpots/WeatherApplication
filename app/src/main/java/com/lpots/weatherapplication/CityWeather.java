package com.lpots.weatherapplication;

public class CityWeather {
    String sity;
    String description;
    String date;
    int img;
    int avgTemp;
    int dayTemp;
    int nightTemp;

    CityWeather(String _sity, String _description, String _date,
                int _img, int _avgTemp, int _dayTemp, int _nightTemp){
        sity = _sity;
        description = _description;
        date = _date;
        img = _img;
        avgTemp = _avgTemp;
        dayTemp = _dayTemp;
        nightTemp = _nightTemp;
    }
}
