package com.tr4n.androidbase.ui.home

import com.tr4n.androidbase.R
import com.tr4n.androidbase.data.model.Photo
import com.tr4n.androidbase.data.repository.PhotosRepository
import com.tr4n.androidbase.data.repository.PhotosRepositoryImpl
import com.tr4n.androidbase.data.source.local.PhotosLocalDataSource
import com.tr4n.androidbase.data.source.remote.PhotosRemoteDataSource
import com.tr4n.base.view.mvp.BaseFragment
import com.tr4n.base.view.showToast
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment private constructor() : BaseFragment(), HomeContract.View {

    override val layoutResource: Int get() = R.layout.fragment_home

    private val photosRepository: PhotosRepository by lazyOf(
        PhotosRepositoryImpl.getInstance(PhotosRemoteDataSource, PhotosLocalDataSource)
    )
    private val presenter by lazyOf(HomePresenter(this, photosRepository))

    private val photoAdapter = PhotoAdapter { photo, position ->
        context?.run {
            showToast(getString(R.string.msg_item_selected, position, photo.id))
        }
    }

    override fun initComponents() {
        recyclerPhotos.adapter = photoAdapter
    }

    override fun initData() {
        presenter.start()
    }

    override fun showPhotos(photos: List<Photo>) {
        photoAdapter.submitList(photos)
    }

    override fun showToast(msg: String) {
        context?.showToast(msg)
    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }
}
