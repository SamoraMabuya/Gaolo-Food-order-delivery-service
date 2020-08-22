package com.example.deliver.customer

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import android.widget.Toast
import com.example.deliver.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.customer_log_in.*
import kotlinx.android.synthetic.main.customer_sign_up.*

class CustomerLogIn : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;
    private val noText: String = "Field Cannot Be Blank";


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_log_in)
        auth = FirebaseAuth.getInstance()

        createAccount()


        CreateAccountText.setOnClickListener {
            startActivity(Intent(this, CustomerSignUp::class.java))
            finish();
        }

        loginButton.setOnClickListener {
            Login();
        }
    }

    private fun Login() {
        if (loginEmail.text.toString().isEmpty()) {
            loginEmail.error = noText;
            loginEmail.requestFocus()
            return
        }
        if (loginPassword.text.toString().isEmpty()) {
            loginPassword.error = noText;
            loginPassword.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(loginEmail.text.toString()).matches()) {
            loginEmail.error = noText;
            loginEmail.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(loginEmail.text.toString(), loginPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    updateUI(null)
                }

            }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)

    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            if (currentUser.isEmailVerified) {
                startActivity(Intent(this, Restaurants::class.java))
            } else {
                Toast.makeText(
                    baseContext, "Verify your email address.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    private fun createAccount() {
        val firstSent = SpannableStringBuilder()
        val login = SpannableString("Create Account.")
        firstSent.append("Don't have an account. \n")
        firstSent.append(login)
        CreateAccountText.text = firstSent;
    }
}



