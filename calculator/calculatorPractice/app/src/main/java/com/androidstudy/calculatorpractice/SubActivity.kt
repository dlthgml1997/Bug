package com.androidstudy.calculatorpractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text
import java.lang.Exception

// 연산자 두번 눌리면 안됨, 우선순위따지기
class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //numbers
        btn_1.setOnClickListener { calculate("1", true) }
        btn_2.setOnClickListener { calculate("2", true) }
        btn_3.setOnClickListener { calculate("3", true) }
        btn_4.setOnClickListener { calculate("4", true) }
        btn_5.setOnClickListener { calculate("5", true) }
        btn_6.setOnClickListener { calculate("6", true) }
        btn_7.setOnClickListener { calculate("7", true) }
        btn_8.setOnClickListener { calculate("8", true) }
        btn_9.setOnClickListener { calculate("9", true) }
        btn_0.setOnClickListener { calculate("0", true) }
        btn_dot.setOnClickListener { calculate(".", true) }

        //operators
        btn_plus.setOnClickListener { calculate("+", false) }
        btn_minus.setOnClickListener { calculate("-", false) }
        btn_div.setOnClickListener { calculate("/", false) }
        btn_mul.setOnClickListener { calculate("*", false) }


        btn_delete.setOnClickListener {
            tv_Expression.text = ""
            tv_result.text = ""
        }

        btn_back.setOnClickListener {
            val string = tv_Expression.text.toString()
            if(string.isNotEmpty()){
                tv_Expression.text= string.substring(0,string.length-1)
            }
            tv_result.text =""
        }

        btn_calcuate.setOnClickListener {
            try {
                val expression = ExpressionBuilder(tv_Expression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result== longResult.toDouble())
                    tv_result.text=longResult.toString()
                else
                    tv_result.text=result.toString()
            }catch (e: Exception){
                Log.d("Exception","message:"+ e.message)
            }
        }

    }

    fun calculate(string: String, canClear: Boolean) {
        if(tv_result.text.isNotEmpty()){
            tv_Expression.text=""
            tv_result.text=""
        }
        if (canClear) { //숫자가 들어오면
            tv_result.text = ""
            tv_Expression.append(string)
        } else { // 연산자나 지우는게 들어오면 //처음에 눌리면 안되게 하기
            var lengthOfExpression = tv_Expression.text.substring(tv_Expression.text.length-1,tv_Expression.text.length)
            if(tv_Expression.text==""){
                tv_Expression.text=""
            } else if(lengthOfExpression== "/" ||lengthOfExpression =="*"||lengthOfExpression =="+"||lengthOfExpression =="-"){
                tv_Expression.text= tv_Expression.text
            }else {
                tv_Expression.append(tv_result.text)
                tv_Expression.append(string)
                tv_result.text = ""
            }
        }
    }

}