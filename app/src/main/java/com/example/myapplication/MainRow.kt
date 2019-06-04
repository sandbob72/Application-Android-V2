package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainRow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.row_main)

        val button_1 = findViewById(R.id.btn1) as Button
        button_1.setOnClickListener(){
            Toast.makeText(this@MainRow, "กดเเลือกซื้อสินค้ารายการที่ x ตามลำดับรายการ", Toast.LENGTH_SHORT).show()
        }
    }
}
