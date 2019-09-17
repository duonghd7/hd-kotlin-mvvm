package hd.kotlin.mvvm.domains.second

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import hd.kotlin.mvvm.R
import hd.kotlin.mvvm.domains.base.BaseViewModel
import hd.kotlin.mvvm.domains.second.dialog.HDialog
import hd.kotlin.mvvm.models.requests.LoginRequest

/**
 * Create on 2019-09-13
 * @author duonghd
 */

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initDialog()
        initView()
    }

    private lateinit var hDialog: HDialog

    private fun initDialog(){
        hDialog = HDialog(this)
        hDialog.setCancelable(false)
        hDialog.setCanceledOnTouchOutside(false)
    }

    private fun initView() {

        findViewById<TextView>(R.id.activity_second_tv_show_dialog).setOnClickListener(View.OnClickListener {
            hDialog.show()
        })

    }

    override fun onBackPressed() {
        finish()
    }
}
