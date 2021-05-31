package com.tsn.coolweather.db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.tsn.coolweather.SunnyWeatherApplication;

/**
 * singleton ,只允许生成一个实例,如果有多个线程，则采用一个排队的机制
 * 数据库管理抽象类,(实体类，多个用逗号隔开；版本号，改变数据库结构要更新版本号)
 */
@Database(entities = {City.class,County.class,Province.class},version =1,exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase {
    /**
     * 创建一个dataBase（数据库）的对象，用于操作数据库
     * 让它singleton！！！数据库名称为 test_database
     */
    private static WeatherDatabase INSTANCE;
    static synchronized WeatherDatabase getDatabase(){
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(SunnyWeatherApplication.getContext().getApplicationContext(), WeatherDatabase.class,"weather_database")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    /**
     * 有多个实体类，则应该写多个dao，写一个函数原型就可以，不用实现
     */
//    public abstract TestDao getTestDao();
}
