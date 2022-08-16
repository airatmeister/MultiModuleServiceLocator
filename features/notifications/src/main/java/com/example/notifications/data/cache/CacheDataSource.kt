package com.example.notifications.data.cache

import android.content.SharedPreferences
import com.example.notifications.data.enums.CacheUserKey

interface CacheDataSource {

    fun saveData(key: CacheUserKey, string: String)
    fun getData(key: CacheUserKey): String

    class Base(private val sharedPreferences: SharedPreferences): CacheDataSource {

        override fun saveData(key: CacheUserKey, string: String) =
            sharedPreferences.edit().putString(key.key, string).apply()

        override fun getData(key: CacheUserKey) =
            sharedPreferences.getString(key.key, "Unknown")!!
    }
}