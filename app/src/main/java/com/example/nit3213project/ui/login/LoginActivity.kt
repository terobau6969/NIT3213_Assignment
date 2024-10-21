package com.example.nit3213project.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ap1.R
import com.example.nit3213project.data.model.LoginRequest
import com.example.nit3213project.data.network.ApiService
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter your username and password", Toast.LENGTH_SHORT).show()
            } else {
                val loginRequest = LoginRequest(username, password)


                apiService.login(loginRequest).enqueue(object : Callback<Map<String, String>> {
                    override fun onResponse(call: Call<Map<String, String>>, response: Response<Map<String, String>>) {
                        if (response.isSuccessful) {
                            val keypass = response.body()?.get("keypass")
                            if (keypass != null) {
                                val intent = Intent(this@LoginActivity, com.example.nit3213project.ui.dashboard.DashboardActivity::class.java)
                                intent.putExtra("KEYPASS", keypass)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                            }
                        } else {
                            Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<Map<String, String>>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}
