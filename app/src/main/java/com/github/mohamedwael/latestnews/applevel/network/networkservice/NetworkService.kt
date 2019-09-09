package com.github.mohamedwael.latestnews.applevel.network.networkservice

import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import com.github.mohamedwael.latestnews.applevel.network.ErrorHandler

interface NetworkService<Response, RestClient> {
    fun execute(
        observable: Observable<Response>,
        responseCallback: (Response) -> Unit,
        errorCallback: (ErrorHandler) -> Unit
    ): Disposable


    fun createRestClient(tClass: Class<RestClient>): RestClient
}