package com.tr4n.androidbase.data.repository

import com.tr4n.androidbase.data.source.PhotosDataSource
import com.tr4n.androidbase.data.source.remote.response.PhotosResponse
import com.tr4n.base.data.OnDataLoadedCallback

class PhotosRepositoryImpl private constructor(
    private val remote: PhotosDataSource.Remote,
    private val local: PhotosDataSource.Local
) : PhotosRepository {

    override fun synchronizePhotos(callback: OnDataLoadedCallback<PhotosResponse>) =
        local.synchronizePhotos(callback)

    override fun getPhotos(q: String, callback: OnDataLoadedCallback<PhotosResponse>) =
        remote.getPhotos(q, callback)

    companion object {
        private var instance: PhotosRepository? = null

        fun getInstance(
            remote: PhotosDataSource.Remote,
            local: PhotosDataSource.Local
        ): PhotosRepository {

            return instance ?: PhotosRepositoryImpl(remote, local).also {
                instance = it
            }
        }
    }
}
