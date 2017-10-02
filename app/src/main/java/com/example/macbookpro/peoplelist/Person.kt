package com.example.macbookpro.peoplelist

import java.io.Serializable


data class Person(var name: String, var email: String) : Serializable {

    override fun toString(): String {
        return "${name.toLowerCase()} - $email"
    }
}