package com.tr4n.androidbase.data.source.remote.request

import android.net.Uri
import com.tr4n.androidbase.data.source.remote.api.ApiConfigs

data class ApiUrl(
    val scheme: String = ApiConfigs.SCHEME_HTTPS,
    val authority: String = ApiConfigs.API_AUTHORITY,
    val paths: List<String> = listOf(ApiConfigs.PATH_API),
    val queryParams: Map<String, Any>
) {
    fun toUrl(): String = Uri.Builder().apply {
        scheme(scheme)
        authority(authority)
        paths.forEach {
            appendPath(it)
        }
        queryParams.forEach {
            appendQueryParameter(it.key, it.value.toString())
        }
    }.toString()
}
