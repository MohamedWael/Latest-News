package com.github.mohamedwael.latestnews.applevel.network

interface ErrorHandler {
    var errorMsgStringRes: Int
    var errorMsgString: String
    var throwable: Throwable?
}