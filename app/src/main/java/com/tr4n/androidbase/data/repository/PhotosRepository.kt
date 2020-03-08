package com.tr4n.androidbase.data.repository

import com.tr4n.androidbase.data.source.PhotosDataSource

interface PhotosRepository : PhotosDataSource.Remote, PhotosDataSource.Local
