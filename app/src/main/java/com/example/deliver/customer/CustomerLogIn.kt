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
import kotlinx.android.synthetic.main.customer_log_in.*

class CustomerLogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_log_in)

        createAccount()
    }


    private fun createAccount() {
        val firstSent = SpannableStringBuilder()
        val login = SpannableString("Create Account.")
        firstSent.append("Don't have an account. \n")
        firstSent.append(login)
        CreateAccountText.text = firstSent


    }
}
