package com.tr4n.base.view

import android.content.Context
import android.widget.Toast

fun Context.showToast(msg: String) =
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

fun Context.showToast(resId: Int) =
    Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show()
