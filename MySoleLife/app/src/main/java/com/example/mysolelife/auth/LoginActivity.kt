package com.example.mysolelife.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mysolelife.MainActivity
import com.example.mysolelife.R
import com.example.mysolelife.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var  binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.joinBtn.setOnClickListener {

            val email = binding.emailArea.test.toString()
            val password = binding.passwordArea.test.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                        startActivity(intent)

                        Toast.makeText(this, "로그인 성공", Toast.LENGTH_LONG).show()

                    } else {

                        Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()

                    }
                }


        }


    }
}