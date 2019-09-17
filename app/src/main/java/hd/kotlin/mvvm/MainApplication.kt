package hd.kotlin.mvvm

import android.app.Application
import hd.kotlin.mvvm.utils.AppUtils

/**
 * Create on 2019-09-11
 * @author duonghd
 */

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppUtils.init(this)
    }
}
