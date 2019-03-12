package com.androidstudy.activitypractice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_main_act_next_page.setOnClickListener {
            val intent : Intent = Intent(this,SubActivity::class.java)
            intent.putExtra("message",et_main_act_message.text.toString())
            startActivity(intent)
        }
    }
}
