package com.tr4n.androidbase.data.source.remote

import com.tr4n.androidbase.BuildConfig
import com.tr4n.androidbase.data.source.PhotosDataSource
import com.tr4n.androidbase.data.source.remote.api.ApiConfigs
import com.tr4n.androidbase.data.source.remote.request.ApiUrl
import com.tr4n.androidbase.data.source.remote.response.PhotosResponse
import com.tr4n.base.data.BaseAsyncTask
import com.tr4n.base.data.OnDataLoadedCallback
import com.tr4n.base.data.remote.RemoteHandler
import org.json.JSONObject

object PhotosRemoteDataSource : PhotosDataSource.Remote {

    override fun getPhotos(q: String, callback: OnDataLoadedCallback<PhotosResponse>) {

        val handler = object : RemoteHandler<PhotosResponse> {
            override fun parseToObject(jsonData: String) = PhotosResponse(JSONObject(jsonData))
        }
        val url = ApiUrl(
            queryParams = mapOf(
                ApiConfigs.QUERY_API_KEY to BuildConfig.PIXABAY_API_KEY,
                ApiConfigs.QUERY_Q to q
            )
        ).toUrl()

        BaseAsyncTask(handler, callback).execute(url)
    }
}
