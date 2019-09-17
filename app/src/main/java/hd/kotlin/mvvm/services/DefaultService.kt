package hd.kotlin.mvvm.services

import hd.kotlin.mvvm.models.requests.LoginRequest
import io.reactivex.Observable

/**
 * Create on 2019-09-11
 * @author duonghd
 */

class DefaultService(private val restAuthService: RestAuthService) : AuthService {

    override fun login(loginRequest: LoginRequest): Observable<Any> {
        return restAuthService.login(loginRequest)
    }

}