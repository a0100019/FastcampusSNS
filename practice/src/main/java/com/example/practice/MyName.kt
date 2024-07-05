package com.example.practice

import java.util.UUID
import javax.inject.Inject


class MyName{

    private val uuid = UUID.randomUUID()
    override fun toString(): String {
        return uuid.toString()
    }

}