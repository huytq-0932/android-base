package com.tr4n.androidbase.ui.home

import com.tr4n.androidbase.data.model.Photo
import com.tr4n.androidbase.ui.base.BasePresenter
import com.tr4n.androidbase.ui.base.BaseView

interface HomeContract {
    interface View : BaseView {
        fun showPhotos(photos: List<Photo>)
    }

    interface Presenter : BasePresenter
}
