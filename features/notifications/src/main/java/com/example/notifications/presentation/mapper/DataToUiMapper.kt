package com.example.notifications.presentation.mapper

import com.example.notifications.presentation.model.User
import com.test.core.common.Mapper

interface DataToUiMapper: Mapper<Pair<String, String>, User> {

    class Base: DataToUiMapper {
        override fun map(input: Pair<String, String>) =
            input.let { (name, secondName) ->
                User(name, secondName)
            }
    }
}