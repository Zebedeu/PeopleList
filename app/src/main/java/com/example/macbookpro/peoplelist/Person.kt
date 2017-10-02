package com.example.macbookpro.peoplelist

import java.io.Serializable

/**
 * Created by macbookpro on 02/10/17.
 */
class Person(var name: String, var email: String) : Serializable {

    override fun toString(): String {
        return "${name.toLowerCase()} - $email"
    }
}