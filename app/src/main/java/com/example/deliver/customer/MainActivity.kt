package com.example.deliver.customer

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import com.example.deliver.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customerBorder.setOnClickListener {
            startActivity(Intent(this, CustomerSignUp::class.java))
            finish();
        }

        CustomerBorder.setOnClickListener {
            startActivity(Intent(this, CustomerLogIn::class.java))
            finish();

        }
    }
}