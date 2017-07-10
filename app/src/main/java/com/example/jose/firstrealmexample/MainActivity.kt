package com.example.jose.firstrealmexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.example.jose.firstrealmexample.Model.Person

import io.realm.Realm

class MainActivity : AppCompatActivity() {

    private var txtName: EditText? = null
    private var txtAge: EditText? = null
    private var btnAdd: Button? = null
    private var btnView: Button? = null
    private var btnDelete: Button? = null
    private var txtView: TextView? = null
    private var realm: Realm? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()

        txtName = findViewById(R.id.txtName) as EditText
        txtAge = findViewById(R.id.txtAge) as EditText
        btnAdd = findViewById(R.id.btnAdd) as Button
        btnView = findViewById(R.id.btnView) as Button
        btnDelete = findViewById(R.id.btnDelete) as Button
        txtView = findViewById(R.id.txtView) as TextView


        btnAdd!!.setOnClickListener { save_to_database(txtName!!.text.toString().trim { it <= ' ' }, Integer.parseInt(txtAge!!.text.toString().trim { it <= ' ' })) }

        btnView!!.setOnClickListener { }


        btnDelete!!.setOnClickListener { }
    }

    private fun save_to_database(Name: String, Age: Int) {
        realm!!.executeTransactionAsync({ bgRealm ->
            val person = bgRealm.createObject<Person>(Person::class.java)
            person.name = Name // este es el error
            person.age = Age
        }, { }) { }

    }

    override fun onDestroy() {
        super.onDestroy()
        realm!!.close()
    }
}
