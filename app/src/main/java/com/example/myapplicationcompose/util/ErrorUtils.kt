package com.example.myapplicationcompose.util

import android.util.Log

class ErrorUtils {


    companion object

    {
        private val TAG = javaClass.simpleName
        fun showLogs(tag: String?, message: String?) {
            Log.e(tag, message!!)
        }
    }
}