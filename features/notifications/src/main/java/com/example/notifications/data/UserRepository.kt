package com.example.notifications.data

import com.example.notifications.data.cache.CacheDataSource
import com.example.notifications.data.enums.CacheUserKey

interface UserRepository {

    fun saveName(name: String)
    fun saveSecondName(secondName: String)
    fun fetchUser(): Pair<String, String>

    class Base(private val cacheDataSource: CacheDataSource): UserRepository{

        override fun saveName(name: String) =
            cacheDataSource.saveData(CacheUserKey.NAME, name)

        override fun saveSecondName(secondName: String) =
            cacheDataSource.saveData(CacheUserKey.SECOND_NAME, secondName)

        override fun fetchUser(): Pair<String, String> =
            Pair(
                cacheDataSource.getData(CacheUserKey.NAME),
                cacheDataSource.getData(CacheUserKey.SECOND_NAME)
            )
    }
}