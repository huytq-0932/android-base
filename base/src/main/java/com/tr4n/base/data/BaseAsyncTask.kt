package com.tr4n.base.data

import android.os.AsyncTask

private const val MESSAGE_NULL_RESULT = "Result is null"

class BaseAsyncTask<P, T>(
    private val handler: DataHandler<P, T>,
    private val callback: OnDataLoadedCallback<T>
) : AsyncTask<P, Void, T?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: P): T? =
        try {
            handler.execute(params[0]) ?: throw Exception(MESSAGE_NULL_RESULT)
        } catch (e: Exception) {
            exception = e
            null
        }

    override fun onPostExecute(result: T?) {
        result?.let(callback::onSuccess) ?: exception?.let(callback::onFailure)
    }
}
