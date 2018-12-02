package com.bigskysolutionsinc.boesen.sprint2kt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    enum class LoginSuccess private constructor(val intValue: Int) {
        login(1),
        password(2),
        success(0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById(R.id.idLoginText) as TextView
        val txtPassword = findViewById(R.id.idPasswordText) as TextView
        val btnLogin = findViewById(R.id.btnLogin) as Button

        btnLogin.setOnClickListener {

            val isOK: LoginSuccess? = null

            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())) {
                MainActivity.LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessageLogin), Toast.LENGTH_SHORT).show()
                    txtLogin.requestFocus()
                }
                MainActivity.LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessagePassword), Toast.LENGTH_SHORT).show()
                    txtPassword.requestFocus()
                }
                else -> startActivity(Intent(this@MainActivity, MainClassList::class.java))
            }
        }

    }

    internal fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "Dave"
        val holdPass = "password"

        if (holdLogin != txtLogin) {
            return LoginSuccess.login
        }

        return if (holdPass != txtPassword) {
            LoginSuccess.password
        } else LoginSuccess.success

    }

}

