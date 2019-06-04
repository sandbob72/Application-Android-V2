package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.databinding.RowMainBinding


class RecyclerViewAdapter (private val context: Context, val activity: MainActivity) : RecyclerView.Adapter<RecyclerViewAdapter.NumberViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NumberViewHolder {
        //return NumberViewHolder(LayoutInflater.from(activity).inflate(R.layout.row_main, p0, false))
        val layoutInflater = LayoutInflater.from(p0.context)
        val binding: RowMainBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.row_main, p0, false)
        return NumberViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return activity.listNumber
    }

    override fun onBindViewHolder(p0: NumberViewHolder, p1: Int) {
        p0.bind(context,p1)
//        p0.text2.text = "ขนาด 215/45 R17 91V"
//        p0.text3.text = "รุ่น Advantage T/A Drive"
//        p0.text4.text = "จำนวนคงเหลือ 100"
//        p0.text5.text = "4,090.-"
//        p0.button.setOnClickListener() {
//            //Toast.makeText(context, "กดเเลือกซื้อสินค้ารายการที่ "+ (p1+1) +" ตามลำดับรายการ", Toast.LENGTH_SHORT).show()
//            val mAlertDialog = AlertDialog.Builder(context)
//            mAlertDialog.setMessage("กดเเลือกซื้อสินค้ารายการที่ " + (p1 + 1) + " ตามลำดับรายการ")
//            mAlertDialog.setPositiveButton("OK") { dialog, which ->
//            }
//            mAlertDialog.show()
//        }
    }

    class NumberViewHolder(val binding: RowMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context,p1: Int){
            binding.datarow = TextRowModel("BFGoodrich","215/45 R17 91V","Advantage T/A Drive","จำนวนคงเหลือ 100")
            binding.text5.text = "4,090.-"
            binding.btn1.text = "สั่งซื้อสินค้า"

            binding.btn1.setOnClickListener({
                val mAlertDialog = AlertDialog.Builder(context)
                mAlertDialog.setMessage("กดเเลือกซื้อสินค้ารายการที่ " + (p1 + 1) + " ตามลำดับรายการ")
                mAlertDialog.setPositiveButton("OK") { dialog, which ->
                }
                 mAlertDialog.show()
            })
        }
    }


//    class NumberViewHolder(v: View) : RecyclerView.ViewHolder(v) {
//        val text1 = v.findViewById<TextView>(R.id.text1)
//        val text2 = v.findViewById<TextView>(R.id.text2)
//        val text3 = v.findViewById<TextView>(R.id.text3)
//        val text4 = v.findViewById<TextView>(R.id.text4)
//        val text5 = v.findViewById<TextView>(R.id.text5)
//        val button = v.findViewById<Button>(R.id.btn1)
//    }
}
