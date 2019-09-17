package hd.kotlin.mvvm.domains.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import hd.kotlin.mvvm.ApiURLs
import hd.kotlin.mvvm.models.requests.LoginRequest
import hd.kotlin.mvvm.services.DefaultService
import hd.kotlin.mvvm.services.RestAuthService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Create on 2019-09-06
 * @author duonghd
 */

class BaseViewModel : ViewModel() {
    private val restClient = Retrofit.Builder()
        .baseUrl(ApiURLs.BASE_API_URL)
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private val authService = DefaultService(restClient.create(RestAuthService::class.java))

    private lateinit var disposable: Disposable

    var loginResponse: MutableLiveData<Any> = MutableLiveData()

    fun login(loginRequest: LoginRequest) {
        disposable = authService.login(loginRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    loginResponse.postValue(data)
                },
                { error ->
                    loginResponse.postValue(error)
                })
    }
}


