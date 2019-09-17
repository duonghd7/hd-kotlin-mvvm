package hd.kotlin.mvvm.utils

import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue

/**
 * Create on 2019-09-17
 * @author duonghd
 */

class AppUtils {

    companion object {
        private lateinit var dm: DisplayMetrics

        fun init(context: Context) {
            dm = context.resources.displayMetrics
        }

        fun getWidth(): Int {
            return dm.widthPixels
        }

        fun dpToPx(dp: Float): Int {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, dm).toInt()
        }
    }
}