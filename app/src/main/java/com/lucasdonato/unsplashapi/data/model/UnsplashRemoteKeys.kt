package com.lucasdonato.unsplashapi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lucasdonato.unsplashapi.utils.Constants.UNSPLASH_REMOTE_KEYS_TABLE

@Entity(tableName = UNSPLASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)