package com.miu.quizapp

import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private lateinit var button: Button
    private lateinit var chbox: CheckBox
    private lateinit var chbox2: CheckBox
    private lateinit var chbox3: CheckBox
    var answeredcorrect=false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when Submit button is clicked

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun Clicked(view: View) {

        var result=0

        // Assigning id of RadioGroup
        radioGroup = findViewById(R.id.radioGroup)

        // Assigning id of Submit button
        button = findViewById(R.id.button)
        chbox=findViewById(R.id.checkBox)
        chbox2=findViewById(R.id.checkBox2)
        chbox3=findViewById(R.id.checkBox3)

        val selectedOption: Int = radioGroup!!.checkedRadioButtonId
        val current = LocalDateTime.now()
        radioButton = findViewById(selectedOption)
        if(view.id==button.id){
            if(R.id.radioButton2==radioButton.id) result=result+50
            if(answeredcorrect) result=result+50

            // Displaying text of the checked radio button in the form of toast
            // Toast.makeText(baseContext, radioButton.text, Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(this)

            with(builder)
            {
                setTitle("Congratulations!!")
                setMessage("submitted on $current, Your achieved $result%")
                setPositiveButton("OK",DialogInterface.OnClickListener {
                        dialog, id -> finish()
                })
//                    setNegativeButton(android.R.string.no, DialogInterface.OnClickListener {
//                        dialog, id -> dialog.cancel()
//                })
                val alert = builder.create()

                alert.show()
            }
        }
        else if(view.id==R.id.checkBox3){
             answeredcorrect=true
            chbox.isChecked=false
             chbox2.isChecked=false
         }
        else if(view.id==chbox2.id){
             answeredcorrect=false
            chbox3.isChecked=false
             chbox.isChecked=false
        }else if(chbox.id==view.id){
             chbox2.isChecked=false
            chbox3.isChecked=false
             answeredcorrect=false
        }else{
             answeredcorrect=false
             chbox.isChecked=false
             chbox2.isChecked=false
             chbox3.isChecked=false
             result=0;
        }

    }

}