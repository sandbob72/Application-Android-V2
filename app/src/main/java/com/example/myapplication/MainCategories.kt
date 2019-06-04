package com.example.myapplication

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.CategoryMainBinding
import kotlinx.android.synthetic.main.activity_main.recycleProduct
import kotlinx.android.synthetic.main.category_main.*

class MainCategories : AppCompatActivity() {

    val listname = arrayOf("a","b","c","d","e")
    val listsize = arrayOf("S","M","L","XL","XXL")

    var listNumber = 0
    var page = 0
    var isLoading = false
    val limit = 5

    lateinit var adapter: MainAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.category_main)
        val binding: CategoryMainBinding = DataBindingUtil.setContentView(this, R.layout.category_main)

        binding.dataCategory = TextCategoryModel("ยางรถยนต์","กรอง","เรียงตาม")

        binding.b1.setOnClickListener({
            val mAlertDialog = AlertDialog.Builder(this@MainCategories)
            mAlertDialog.setMessage("กดเเมนูการกรอง")
            mAlertDialog.setPositiveButton("OK"){
                    dialog, which ->
            }
            mAlertDialog.show()
        })

        binding.b2.setOnClickListener({
            val mAlertDialog = AlertDialog.Builder(this@MainCategories)
            mAlertDialog.setMessage("กดเเมนูเรียงตาม")
            mAlertDialog.setPositiveButton("OK"){
                    dialog, which ->
            }
            mAlertDialog.show()
        })




        //recycleProduct.layoutManager = LinearLayoutManager(this)
        //recycleProduct.adapter = MainAdapter(this,listname,listsize,this)

        layoutManager = LinearLayoutManager(this)
        recycleProduct.layoutManager = layoutManager
        getPage()

        recycleProduct.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                val total = adapter.itemCount

                    if (!isLoading) {
                        if ((visibleItemCount + pastVisibleItem) >= total){
                            page++
                            getPage()
                        }
                    }
                super.onScrolled(recyclerView, dx, dy)
            }
        })


//        b1.setOnClickListener(){
//            val mAlertDialog = AlertDialog.Builder(this@MainCategories)
//            mAlertDialog.setMessage("กดเเมนูการกรอง")
//            mAlertDialog.setPositiveButton("OK"){
//                    dialog, which ->
//            }
//            mAlertDialog.show()
//        }

//        b2.setOnClickListener(){
//            val mAlertDialog = AlertDialog.Builder(this@MainCategories)
//            mAlertDialog.setMessage("กดเเมนูเรียงตาม")
//            mAlertDialog.setPositiveButton("OK"){
//                    dialog, which ->
//            }
//            mAlertDialog.show()
//        }
    }


    fun getPage() {
        isLoading = true
        progressBar.visibility = View.VISIBLE
        val start = ((page)*limit) + 1
        val end = (page + 1) * limit

        for (i in start..end){
            listNumber++
        }
        Handler().postDelayed({
            if (::adapter.isInitialized){
                adapter.notifyDataSetChanged()
            }
            else{
                adapter = MainAdapter(this,listname,listsize,this)
                recycleProduct.adapter = adapter
            }
            isLoading = false
            progressBar.visibility = View.GONE
        },3000)
    }
}
