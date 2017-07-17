package com.example.jose.firstrealmexample.Model

import io.realm.RealmObject


/**
 * Created by jose on 16/06/17.
 */

open class Person(

        var name: String = "",

        var age: Int = 0

) : RealmObject()

