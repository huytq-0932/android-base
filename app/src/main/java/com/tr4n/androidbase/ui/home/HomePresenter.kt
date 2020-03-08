package com.tr4n.androidbase.ui.home

import com.tr4n.androidbase.data.model.Photo
import com.tr4n.androidbase.data.repository.PhotosRepository
import com.tr4n.androidbase.data.source.remote.response.PhotosResponse
import com.tr4n.base.data.OnDataLoadedCallback

class HomePresenter(
    private val homeView: HomeContract.View,
    private val repository: PhotosRepository
) : HomeContract.Presenter {

    override fun start() {
        repository.getPhotos("vietnam", object : OnDataLoadedCallback<PhotosResponse> {
            override fun onSuccess(data: PhotosResponse) {
                val photos = data.hits.map { Photo(it) }
                homeView.showPhotos(photos)
                homeView.showToast(photos.toString())
            }

            override fun onFailure(exception: Exception) {
                homeView.showToast(exception.message.toString())
            }
        })
    }
}
