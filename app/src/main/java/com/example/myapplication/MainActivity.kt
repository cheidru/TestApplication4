package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {

    val CHOOSE_COLOR = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun clicNext(view: View) {
//        val intent = Intent(this, TestActivity::class.java)
//                startActivity(intent)

        val questionIntent = Intent(this,
                TestActivity::class.java)
        startActivityForResult(questionIntent, CHOOSE_COLOR)
//        onActivityResult()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==CHOOSE_COLOR){
            if (resultCode==RESULT_OK) {
                val loMain = findViewById<ConstraintLayout> (R.id.layoutMain)
                val txtRes = findViewById<TextView>(R.id.txtV)
//                loMain.setBackgroundColor(data as Int)
                val colnum : String? = data?.getStringExtra("ANSWER")

                txtRes.text = "Request " + requestCode + " Result " + resultCode + " data " + colnum

            }
        }

    }
}