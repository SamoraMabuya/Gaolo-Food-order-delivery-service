package com.example.deliver.customer

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.deliver.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.loginText
import kotlinx.android.synthetic.main.customer_log_in.*
import kotlinx.android.synthetic.main.customer_sign_up.*
import kotlinx.android.synthetic.main.customer_sign_up.email

class CustomerSignUp : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private val noText: String = "Field Cannot Be Blank";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_sign_up)
        loginText()

        auth = FirebaseAuth.getInstance()

        SignUpButton.setOnClickListener {
            userSignUp();
        }

        loginText.setOnClickListener {
            startActivity(Intent(this, CustomerLogIn::class.java))
            finish();
        }
    }

    fun userSignUp() {
        if (username.text.toString().isEmpty()) {
            username.error = noText;
            username.requestFocus()
            return
        }
        if (email.text.toString().isEmpty()) {
            email.error = noText;
            email.requestFocus()
            return
        }
        if (password.text.toString().isEmpty()) {
            password.error = noText;
            password.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()) {
            email.error = noText;
            email.requestFocus()
            return
        }
        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser

                    user?.sendEmailVerification()
                        ?.addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                startActivity(Intent(this, CustomerLogIn::class.java))
                                finish();
                            } else {
                                Toast.makeText(
                                    baseContext,
                                    "Sign Up failed. Try again after a few minutes",
                                    Toast.LENGTH_SHORT
                                ).show();
                            }
                        }
                }
            }
    }


    private fun loginText() {
        val firstSent = SpannableStringBuilder()
        val login = SpannableString("Log In.")
        firstSent.append("I Already have an account.\n")
        firstSent.append(login)
        loginText.text = firstSent

    }
}







