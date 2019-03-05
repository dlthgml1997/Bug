package com.androidstudy.calculatorpractice

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text
import java.util.ArrayList
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    var str: String = ""
    var str1: String = ""
    var result : Double? = null
    var str2: String = ""
    var a: Double? = null
    var b: Double? = null
    var sign: String = ""
    var screen: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        screen = tv_result
        str =""
        btn_delete.setOnClickListener { screen!!.setText("")
        str = ""}
    }

    fun onClicknums(v: View) {
 var tv : TextView = v as TextView
        str += tv.text.toString()
        screen!!.setText(str)
       // a = str.toDoubleOrNull()
    }

    fun onClickSigns(v: View) {
       var tv = v as TextView
        a= screen!!.text.toString().toDoubleOrNull()
        if(str=="") {screen!!.setText("")
            }else{
        sign = tv.text.toString()
        screen!!.setText(sign)
        str = ""}
    }

    fun onClickCalculate(v: View) {
        if(str==null||str==""){
            screen!!.setText("")
        }
        str2= screen!!.text.toString()
        b = str2.toDoubleOrNull()
        when(sign){
            "+" -> result =a!!+b!!
            "-" -> result =a!!-b!!
            "%" -> result =a!!%b!!
            "*" -> result =a!!*b!!
            else -> screen!!.setText("")
        }
        screen!!.setText(result.toString())
        a=null
        b=null
    }
}
