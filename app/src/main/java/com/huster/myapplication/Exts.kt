package com.huster.myapplication

import android.content.Context
import android.widget.Toast

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}