package hd.kotlin.mvvm.domains.second.dialog

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hd.kotlin.mvvm.R
import hd.kotlin.mvvm.domains.second.adapter.RecyclerUsersAdapter
import hd.kotlin.mvvm.domains.second.adapter.RecyclerUsersAdapter.*
import hd.kotlin.mvvm.models.responses.User
import hd.kotlin.mvvm.utils.AppUtils

/**
 * Create on 2019-09-17
 * @author duonghd
 */

class HDialog(context: Context) : Dialog(context, R.style.dialogStyle) {
    private val TAG = HDialog::class.java.simpleName
    private val usersAdapter = RecyclerUsersAdapter()

    init {
        setContentView(R.layout.dialog_hd)

        val window = window!!
        val params = window.attributes
        params.gravity = Gravity.CENTER
        params.width = AppUtils.getWidth() - AppUtils.dpToPx(60F)
        params.height = AppUtils.dpToPx(400F)
        window.attributes = params

        usersAdapter.setItemClickListener(object : ItemClickListener {
            override fun onClick(user: User) {
                Log.e(TAG, user.name)
            }
        })

        findViewById<TextView>(R.id.dialog_hd_tv_title).setOnClickListener(View.OnClickListener {
            val users = mutableListOf<User>()

            users.add(User(0, "user 0"))
            users.add(User(1, "user 1"))
            users.add(User(2, "user 2"))
            users.add(User(3, "user 3"))
            users.add(User(4, "user 4"))
            users.add(User(5, "user 5"))
            users.add(User(6, "user 6"))
            users.add(User(7, "user 7"))
            users.add(User(8, "user 8"))
            users.add(User(9, "user 9"))

            usersAdapter.updateData(users)
        })

        findViewById<TextView>(R.id.dialog_hd_tv_close).setOnClickListener(View.OnClickListener {
            dismiss()
        })

        findViewById<RecyclerView>(R.id.dialog_hd_rcv_users).let { rcv ->
            rcv.layoutManager = LinearLayoutManager(context)
            rcv.setHasFixedSize(true)
            rcv.adapter = usersAdapter
        }
    }
}