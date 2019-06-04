package com.example.myapplication

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.RowMain2Binding
import com.example.myapplication.databinding.RowMainBinding
import kotlinx.android.synthetic.main.row_main.view.*


class MainAdapter(private val context: Context, var mList: Array<String>, var listsize : Array<String>, val activity: MainCategories): RecyclerView.Adapter<CustomViewHolder>(){

    override fun getItemCount(): Int {
        return activity.listNumber
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
//        val layoutInflater = LayoutInflater.from(p0?.context)
//        val cellForRow = layoutInflater.inflate(R.layout.row_main, p0, false)
//        return CustomViewHolder(cellForRow)
        val layoutInflater = LayoutInflater.from(p0.context)
        val binding : RowMain2Binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.row_main2, p0, false)
        return CustomViewHolder(binding)

    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        p0.bind(context, p1)
//        p0?.view?.text1?.text = "ยี่ห้อ BFGoodrich"
//        p0?.view?.text2?.text = "ขนาด 215/45 R17 91V"
//        p0?.view?.text3?.text = "รุ่น Advantage T/A Drive"
//        p0?.view?.text4?.text = "จำนวนคงเหลือ 100"
//        p0?.view?.text5?.text = "4,090.-"
//
//        p0?.view?.btn1?.setOnClickListener(){
//            //Toast.makeText(context, "กดเเลือกซื้อสินค้ารายการที่ "+ (p1+1) +" ตามลำดับรายการ", Toast.LENGTH_SHORT).show()
//            val mAlertDialog = AlertDialog.Builder(context)
//            mAlertDialog.setMessage("กดเเลือกซื้อสินค้ารายการที่ "+ (p1+1) +" ตามลำดับรายการ")
//            mAlertDialog.setPositiveButton("OK"){
//                    dialog, which ->
//            }
//            mAlertDialog.show()
//        }

    }


}

class CustomViewHolder(val binding: RowMain2Binding): RecyclerView.ViewHolder(binding.root){
    fun bind(context: Context,p1: Int){

        binding.text1.text = "BFGoodrich"
        binding.text2.text = "215/45 R17 91V"
        binding.text3.text = "Advantage T/A Drive"
        binding.text4.text = "จำนวนคงเหลือ 100"
        binding.text5.text = "4,090.-"
        binding.btn1.text="สั่งซื้อสินค้า"
        binding.btn1.setOnClickListener({
            val mAlertDialog = android.app.AlertDialog.Builder(context)
            mAlertDialog.setMessage("กดเเลือกซื้อสินค้ารายการที่ " + (p1 + 1) + " ตามลำดับรายการ")
            mAlertDialog.setPositiveButton("OK") { dialog, which ->
            }
            mAlertDialog.show()
        })
    }
}

//class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){
//
//}
