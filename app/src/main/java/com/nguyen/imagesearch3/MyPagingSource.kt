package com.nguyen.imagesearch3

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import java.io.IOException

private const val UNSPLASH_START_PAGE = 1

class MyPagingSource(private val service: UnsplashService, private val query: String): PagingSource<Int, Photo>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val position = params.key ?: UNSPLASH_START_PAGE
        return try {
            val response = service.searchPhotos(query, position, params.loadSize)
            val data = response.results
            val prevKey = if (position == UNSPLASH_START_PAGE) null else position - 1
            val nextKey = if (data.isEmpty()) null else position + 1
            LoadResult.Page(data, prevKey, nextKey)
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>) = null
}