package com.tr4n.androidbase.data.model

import com.tr4n.androidbase.data.source.remote.response.PhotosResponse

data class Photo(val id: Int, val url: String) {

    constructor(hit: PhotosResponse.Hit) : this(hit.id, hit.webFormatUrl)
}
