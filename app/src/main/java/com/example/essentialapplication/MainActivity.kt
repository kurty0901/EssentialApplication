package com.example.essentialapplication

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.essentialapplication.ui.theme.EssentialApplicationTheme
import android.app.DatePickerDialog
import android.widget.Button
import android.widget.DatePicker
import java.util.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner

class MainActivity : ComponentActivity() {

    private lateinit var dateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.record_trip_information)
        dateButton = findViewById(R.id.button_datepicker)


        val ports = arrayOf("Annalong -11", "Ardglass -20", "Ballintoy -53", "Ballycastle -56", "Ballydorn -49", "Ballyhalbert -48", "Ballywalter -37", "Bangor -38", "Belfast -55", "Carnlough -58", "Carrickfergus -54", "Coleraine -15", "Cushendall -23", "Cushendun 24", "Donaghadee -39", "Dundrum -13", "Dunseverick -21", "Glenarm -16", "Groomsport -46", "Islandmagee -18", "Kilkeel -10", "Killough -44", "Killyleagh -43", "Larne -59", "Londonderry - 45", "Newry -35", "Portaferry -36", "Portavogie -30", "Portballintrae -52", "Portrush -51", "Portstewart -25", "Rathlin Island -57", "Red Bay -26", "Ringhaddy -47", "Strangford -41", "Waterfoot -22", "Whitehead -17", "Whiterock -42", "Other")
        val spinner: Spinner = findViewById(R.id.spinner_port)
        val otherEditText: EditText = findViewById(R.id.editText_other)

        ArrayAdapter(this, android.R.layout.simple_spinner_item, ports).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                if (selectedItem == "Other") {
                    otherEditText.visibility = View.VISIBLE
                } else {
                    otherEditText.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }

        }

    fun openDatePicker(view: View) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            dateButton.text = "${dayOfMonth}/${monthOfYear + 1}/$year"
        }, year, month, day).show()
    }
}



