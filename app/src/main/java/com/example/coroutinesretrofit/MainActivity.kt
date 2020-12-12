package com.example.coroutinesretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.coroutinesretrofit.ui.home.movies.MoviesFragment
import com.example.coroutinesretrofit.ui.home.quotes.QuotesFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment, QuotesFragment())
        transaction.commit()
    }
}