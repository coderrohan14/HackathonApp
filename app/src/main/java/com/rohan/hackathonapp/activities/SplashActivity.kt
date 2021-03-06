package com.rohan.hackathonapp.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.rohan.hackathonapp.R

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 1500L
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        auth = FirebaseAuth.getInstance()
        Handler().postDelayed(
            {
                getLoggedInState()
                finish()
            }, SPLASH_TIME_OUT)
    }
    private fun getLoggedInState(){
        if(auth.currentUser==null){
            Intent(this, LoginActivity::class.java).also{
                startActivity(it)
            }
        }
        else{
            Intent(this, HomeActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}