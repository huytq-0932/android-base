package com.tr4n.base.data.remote

import com.tr4n.base.data.DataHandler
import org.json.JSONException
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

private const val METHOD_GET = "GET"
private const val MESSAGE_EXCEPTION_IO_HTTP = "Connection error"

interface RemoteHandler<T> : DataHandler<String, T> {

    @Throws(IOException::class, JSONException::class)
    override fun execute(params: String): T? {
        var responseData: T?
        var connection: HttpURLConnection? = null
        try {
            connection = (URL(params).openConnection() as HttpURLConnection).apply {
                build(METHOD_GET)
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    throw IOException(MESSAGE_EXCEPTION_IO_HTTP)
                }

                InputStreamReader(inputStream).run {
                    responseData = parseToObject(getJsonString())
                    close()
                }
            }
        } finally {
            connection?.disconnect()
        }
        return responseData
    }

    @Throws(JSONException::class)
    fun parseToObject(jsonData: String): T
}
