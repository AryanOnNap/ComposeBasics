package com.example.myapplicationcompose.todoDao.dependancyInjection

import android.app.Application
import androidx.room.Room
import com.example.myapplicationcompose.todoDao.DaoInterface
import com.example.myapplicationcompose.todoDao.Tododatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application):Tododatabase =
        Room.databaseBuilder(application,Tododatabase::class.java,"TodoDatabase")
            .fallbackToDestructiveMigration()
            .build()


    @Provides
    @Singleton
    fun providesDao(db:Tododatabase):DaoInterface =db.getDao();
}