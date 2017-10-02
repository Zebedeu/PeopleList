package com.example.macbookpro.peoplelist

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnSend.setOnClickListener{
            val name = edName.text.toString()
            val email = edEmail.text.toString()
            val person = Person(name, email)

            val intent = Intent()
            intent.putExtra(EXTRA_PERSON, person)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
    companion object {
        val EXTRA_PERSON = "Person"
    }

}
