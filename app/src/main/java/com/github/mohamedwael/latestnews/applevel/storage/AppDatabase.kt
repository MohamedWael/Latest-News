package com.github.mohamedwael.latestnews.applevel.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.mohamedwael.latestnews.R
import com.github.mohamedwael.latestnews.applevel.storage.dao.ArticlesDao
import com.github.mohamedwael.latestnews.modules.response.ArticlesItem


@Database(
    entities = [ArticlesItem::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    context.getString(R.string.data_base_name)
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }

    abstract fun articlesDao(): ArticlesDao
}