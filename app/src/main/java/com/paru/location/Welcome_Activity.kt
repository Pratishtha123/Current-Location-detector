package com.paru.location

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome_.*

class Welcome_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_)

        btn_locate.setOnClickListener{
            val intent=Intent(this@Welcome_Activity,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
