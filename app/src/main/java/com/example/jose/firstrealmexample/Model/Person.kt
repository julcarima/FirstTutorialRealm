package com.example.jose.firstrealmexample.Model

import io.realm.RealmObject
import java.util.jar.Attributes

/**
 * Created by jose on 16/06/17.
 */

class Person : RealmObject() {

    override fun toString(): String {
        return "Person{" +
                "Name='" + name + '\'' +
                ", Age=" + age +
                '}'
    }

    val name: String = ""
    var age: Int = 0
}
