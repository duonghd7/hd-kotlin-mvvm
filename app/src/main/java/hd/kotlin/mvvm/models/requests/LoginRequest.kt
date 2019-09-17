package hd.kotlin.mvvm.models.requests

import com.google.gson.annotations.SerializedName

/**
 * Create on 2019-09-11
 * @author duonghd
 */

class LoginRequest(
    @SerializedName("username") private val name: String,
    @SerializedName("password") private val pass: String
)