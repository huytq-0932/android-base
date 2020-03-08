package com.tr4n.androidbase.data.source.remote.response

import org.json.JSONObject

data class PhotosResponse(val hits: List<Hit>)  {

    constructor(json: JSONObject) : this(
        hits = mutableListOf<Hit>().apply {
            val hitsJson = json.getJSONArray(HITS)
            for (index in 0 until hitsJson.length()) {
                add(Hit(hitsJson.optJSONObject(index)))
            }
        }
    )

    data class Hit(val id: Int, val webFormatUrl: String) {

        constructor(json: JSONObject) : this(
            id = json.optInt(ID),
            webFormatUrl = json.optString(WEB_FORMAT_URL)
        )
    }

    companion object {
        private const val ID = "id"
        private const val WEB_FORMAT_URL = "webformatURL"
        private const val HITS = "hits"
    }
}
