package hd.kotlin.mvvm.services

import hd.kotlin.mvvm.models.requests.LoginRequest
import io.reactivex.Observable

/**
 * Create on 2019-09-11
 * @author duonghd
 */

interface AuthService {
    fun login(loginRequest: LoginRequest): Observable<Any>
}