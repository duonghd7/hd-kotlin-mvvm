package hd.kotlin.mvvm.models.responses

import com.google.gson.Gson

/**
 * Create on 2019-09-06
 * @author duonghd
 */

data class User(val id: Int, val name: String) {

    override fun toString(): String {
        return Gson().toJson(this)

    }
}