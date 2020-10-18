package com.evans.unsplash.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.evans.unsplash.api.ApiClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepository @Inject constructor(private val apiClient: ApiClient) {

    fun getSearchResult(query: String) = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100, enablePlaceholders = false),
        pagingSourceFactory = { PhotoPagingSource(apiClient, query) }
    ).liveData
}