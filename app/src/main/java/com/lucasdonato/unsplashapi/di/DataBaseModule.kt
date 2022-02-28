package com.lucasdonato.unsplashapi.di

import android.content.Context
import androidx.room.Room
import com.lucasdonato.unsplashapi.data.local.UnsplashDatabase
import com.lucasdonato.unsplashapi.utils.Constants.UNSPLASH_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): UnsplashDatabase {
        return Room.databaseBuilder(context, UnsplashDatabase::class.java, UNSPLASH_DATABASE)
            .build()
    }

}