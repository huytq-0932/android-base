package com.tr4n.base.data

interface DataHandler<in P, out T> {
    @Throws(Exception::class)
    fun execute(params: P): T?
}
