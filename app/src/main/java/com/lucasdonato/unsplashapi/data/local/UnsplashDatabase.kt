package com.lucasdonato.unsplashapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lucasdonato.unsplashapi.data.local.dao.UnsplashImageDao
import com.lucasdonato.unsplashapi.data.local.dao.UnsplashRemoteKeysDao
import com.lucasdonato.unsplashapi.data.model.UnsplashImage
import com.lucasdonato.unsplashapi.data.model.UnsplashRemoteKeys

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}