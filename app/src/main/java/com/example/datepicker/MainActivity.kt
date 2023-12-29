package com.example.datepicker

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private val calender = Calendar.getInstance()
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.txtSelectDate)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            showDatePicker()
        }


    }

    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
            { DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectDate = Calendar.getInstance()
                selectDate.set(year, monthOfYear, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectDate.time)
                textView.text = "Selected Date" + formattedDate
            },
            calender.get(Calendar.YEAR),
            calender.get(Calendar.MONTH),
            calender.get(Calendar.DAY_OF_MONTH),

            )
        datePickerDialog.show()

    }
}