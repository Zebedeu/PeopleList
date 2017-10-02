package com.example.macbookpro.peoplelist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private val peoplo: MutableList<Person> by lazy { mutableListOf<Person>() }
    private var adapter : ArrayAdapter<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivityForResult(intent, REQUEST_INSERT)
        }
        listPerson.setOnItemClickListener { _, _, position, _ ->
            ItemClickShortToast(peoplo[position].name)
        }

        adapter = ArrayAdapter<Person>(this, android.R.layout.simple_expandable_list_item_1, peoplo)
        listPerson.adapter = adapter


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_INSERT && resultCode == RESULT_OK) {
            val person = data?.getSerializableExtra(DetailActivity.EXTRA_PERSON) as? Person
            if (person != null) {
                peoplo.add(person)
                peoplo.sortBy { it.name }
                adapter?.notifyDataSetChanged()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    companion object {
        val REQUEST_INSERT = 0
    }
}
