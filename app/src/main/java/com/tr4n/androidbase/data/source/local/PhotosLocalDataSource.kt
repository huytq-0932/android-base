package com.tr4n.androidbase.data.source.local

import com.tr4n.androidbase.data.source.PhotosDataSource
import com.tr4n.androidbase.data.source.remote.response.PhotosResponse
import com.tr4n.base.data.OnDataLoadedCallback

object PhotosLocalDataSource : PhotosDataSource.Local {

    override fun synchronizePhotos(callback: OnDataLoadedCallback<PhotosResponse>) {
        TODO("Not yet implemented")
    }
}
