package com.tr4n.androidbase.data.source

import com.tr4n.androidbase.data.source.remote.response.PhotosResponse
import com.tr4n.base.data.OnDataLoadedCallback

class PhotosDataSource {

    interface Local {
        fun synchronizePhotos(callback: OnDataLoadedCallback<PhotosResponse>)
    }

    interface Remote {
        fun getPhotos(q: String, callback: OnDataLoadedCallback<PhotosResponse>)
    }
}