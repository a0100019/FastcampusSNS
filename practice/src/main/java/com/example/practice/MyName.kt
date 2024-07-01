package com.example.practice

import javax.inject.Inject


class MyName @Inject constructor() {

    override fun toString(): String {
        return "페스트캠퍼스"
    }

}