package com.example.macbookpro.peoplelist

import android.app.Activity
import android.widget.Toast


fun Activity.ItemClickShortToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}