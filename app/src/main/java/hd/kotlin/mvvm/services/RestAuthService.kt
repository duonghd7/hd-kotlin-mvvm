package hd.kotlin.mvvm.services

import hd.kotlin.mvvm.models.requests.LoginRequest
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Create on 2019-09-11
 * @author duonghd
 */

interface RestAuthService {

    @POST("api/auth/sign-in")
    fun login(@Body loginRequest: LoginRequest): Observable<Any>
}