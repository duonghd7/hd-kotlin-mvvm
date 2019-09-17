package hd.kotlin.mvvm.domains.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import hd.kotlin.mvvm.R
import hd.kotlin.mvvm.domains.base.BaseViewModel
import hd.kotlin.mvvm.domains.second.SecondActivity
import hd.kotlin.mvvm.models.requests.LoginRequest

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: BaseViewModel

    private lateinit var tvContent: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initView()
    }

    private lateinit var ob: Observer<Any>

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this)[BaseViewModel::class.java]
    }

    private fun initView() {
        tvContent = findViewById(R.id.activity_main_tv_content)

        ob = Observer { t ->
            t?.let {
                tvContent.text = (t.toString())
                viewModel.loginResponse.removeObserver(ob)
                viewModel.loginResponse.postValue(null)
            }
        }

        findViewById<TextView>(R.id.activity_main_tv_submit).setOnClickListener(View.OnClickListener {
            tvContent.text = ("Loading...")
            viewModel.loginResponse.observe(this, ob)
            viewModel.login(LoginRequest("duonghd", "123456"))
        })

        findViewById<TextView>(R.id.activity_main_tv_submit_2).setOnClickListener(View.OnClickListener {
            tvContent.text = ("Hello")
        })

        findViewById<TextView>(R.id.activity_main_tv_submit_3).setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        })
    }
}
