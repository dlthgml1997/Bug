package com.androidstudy.activitypractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
    }
}