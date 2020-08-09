package com.example.deliver.customer

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

        loginText()
    }


    private fun loginText() {
        val firstSent = SpannableStringBuilder()
        val login = SpannableString("Log In.")
        login.setSpan(
            ForegroundColorSpan(Color.BLUE), 0, 7,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        firstSent.append("I Already have an account. \n")
        firstSent.append(login)
        loginText.text = firstSent


    }
}
