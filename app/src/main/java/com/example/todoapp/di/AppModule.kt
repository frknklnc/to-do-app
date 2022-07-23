package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.repo.ToDoDaoRepository
import com.example.todoapp.room.ToDoDao
import com.example.todoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDoDaoRepository(tdao:ToDoDao) : ToDoDaoRepository{
        return ToDoDaoRepository(tdao)
    }

    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context:Context) : ToDoDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"todo.sqlite")
            .createFromAsset("todo.sqlite").build()
        return vt.getToDoDao()
    }
}