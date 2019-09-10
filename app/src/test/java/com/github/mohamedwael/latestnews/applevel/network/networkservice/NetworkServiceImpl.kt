package com.github.mohamedwael.latestnews.applevel.network.networkservice

import com.github.mohamedwael.latestnews.applevel.network.ErrorHandler
import com.github.mohamedwael.latestnews.applevel.network.ErrorHandlerImpl
import com.github.mohamedwael.latestnews.applevel.network.Retrofit
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class NetworkServiceImpl<Response, RestClient> : NetworkService<Response, RestClient> {

    override fun execute(
        observable: Observable<Response>,
        responseCallback: (Response) -> Unit,
        errorCallback: (ErrorHandler) -> Unit
    ): Disposable = observable
        .subscribeOn(Schedulers.io())
        .subscribe({
            responseCallback(it)
        }, { errorCallback(ErrorHandlerImpl(it)) })


    override fun createRestClient(tClass: Class<RestClient>): RestClient {
        return Retrofit.createClient(tClass)
    }
}