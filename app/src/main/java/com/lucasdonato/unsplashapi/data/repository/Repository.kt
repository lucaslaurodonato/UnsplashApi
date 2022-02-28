package com.lucasdonato.unsplashapi.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.lucasdonato.unsplashapi.data.local.UnsplashDatabase
import com.lucasdonato.unsplashapi.data.paging.SearchPagingSource
import com.lucasdonato.unsplashapi.data.paging.UnsplashRemoteMediator
import com.lucasdonato.unsplashapi.data.remote.WebService
import com.lucasdonato.unsplashapi.data.model.UnsplashImage
import com.lucasdonato.unsplashapi.utils.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class Repository @Inject constructor(
    private val webService: WebService, private val unsplashDatabase: UnsplashDatabase
) {

    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = {
            unsplashDatabase.unsplashImageDao().getAllImages()
        }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnsplashRemoteMediator(
                unsplashDatabase = unsplashDatabase, webService = webService
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    fun searchImages(query: String): Flow<PagingData<UnsplashImage>> {
        return Pager(config = PagingConfig(pageSize = ITEMS_PER_PAGE), pagingSourceFactory = {
            SearchPagingSource(unsplashApi = webService, query = query)
        }).flow
    }
}