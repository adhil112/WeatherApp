package com.test.weatherappliaction.data.local
import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.weatherappliaction.model.local_tbl.WeatherLocalData


@Database(
    entities = [
        WeatherLocalData::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}