package com.example.essentialapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.ComponentActivity
import java.util.Calendar


class MainActivity : ComponentActivity() {

    private lateinit var dateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.record_trip_information)
        dateButton = findViewById(R.id.button_datepicker)

        //<editor-fold desc="Port DropDown">
        val ports = arrayOf("Annalong -11", "Ardglass -20", "Ballintoy -53", "Ballycastle -56", "Ballydorn -49", "Ballyhalbert -48", "Ballywalter -37", "Bangor -38", "Belfast -55", "Carnlough -58", "Carrickfergus -54", "Coleraine -15", "Cushendall -23", "Cushendun 24", "Donaghadee -39", "Dundrum -13", "Dunseverick -21", "Glenarm -16", "Groomsport -46", "Islandmagee -18", "Kilkeel -10", "Killough -44", "Killyleagh -43", "Larne -59", "Londonderry - 45", "Newry -35", "Portaferry -36", "Portavogie -30", "Portballintrae -52", "Portrush -51", "Portstewart -25", "Rathlin Island -57", "Red Bay -26", "Ringhaddy -47", "Strangford -41", "Waterfoot -22", "Whitehead -17", "Whiterock -42", "Other")
        val spinnerPort: Spinner = findViewById(R.id.spinner_port)
        val portEditText: EditText = findViewById(R.id.editText_other)

        ArrayAdapter(this, android.R.layout.simple_spinner_item, ports).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerPort.adapter = adapter
        }

        spinnerPort.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                if (selectedItem == "Other") {
                    portEditText.visibility = View.VISIBLE
                } else {
                    portEditText.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
//</editor-fold>

        //<editor-fold desc="Region DropDown"
        val region = arrayOf("West Coast of Scotland - (Vla)","Irish Sea - (Vlla)")
        val spinnerRegion: Spinner = findViewById(R.id.spinner_region)
        val regionEditText: EditText = findViewById(R.id.editText_regionshow)

        ArrayAdapter(this, android.R.layout.simple_spinner_item, region).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerRegion.adapter = adapter
        }

        spinnerRegion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                if (selectedItem == "Other") {
                    regionEditText.visibility = View.VISIBLE
                } else {
                    regionEditText.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
        //</editor-fold>

        //<editor-fold desc="Specie DropDown"
        val specie = arrayOf("Velvet Crab","Brown Crab","Lobster","Whelks","Nephrops","Shrimp","Other")
        val spinnerSpecie: Spinner = findViewById(R.id.spinner_specie)
        val specieEditText: EditText = findViewById(R.id.editText_specieshow)

        ArrayAdapter(this, android.R.layout.simple_spinner_item, specie).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSpecie.adapter = adapter
        }

        spinnerSpecie.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                if (selectedItem == "Other") {
                    specieEditText.visibility = View.VISIBLE
                } else {
                    specieEditText.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another interface callback
            }
        }
        //</editor-fold>



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



