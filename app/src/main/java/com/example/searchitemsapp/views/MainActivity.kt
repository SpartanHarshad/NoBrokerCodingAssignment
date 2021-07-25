package com.example.searchitemsapp.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.searchitemsapp.R
import com.example.searchitemsapp.adapter.ItemAdapter
import com.example.searchitemsapp.clicklistener.OnClickListener
import com.example.searchitemsapp.local.ItemEntity
import com.example.searchitemsapp.model.ResponseItem
import com.example.searchitemsapp.viewmodels.ItemApplication
import com.example.searchitemsapp.viewmodels.ItemViewModel
import com.example.searchitemsapp.viewmodels.ItemViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),OnClickListener {

    lateinit var viewModel: ItemViewModel
    var itemList = mutableListOf<ItemEntity>()
    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val itemApplication = application as ItemApplication
        val itemRepository = itemApplication.itemRepository
        val viewModelFactory = ItemViewModelFactory(itemRepository)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ItemViewModel::class.java)
        setRecyclerView()
        btnCAllApi.setOnClickListener {
            callApi();
        }
    }

    private fun setRecyclerView() {
        itemAdapter = ItemAdapter(itemList,this)
        RvItems.layoutManager = LinearLayoutManager(this)
        RvItems.adapter = itemAdapter
      }

    private fun callApi() {
         viewModel.getItemListFromAPi()
        viewModel.showListData().observe(this, Observer {
            itemList.clear()
            itemList.addAll(it)
            Log.d("TAG_1","${it}")
            itemAdapter.notifyDataSetChanged()
        })
    }

    override fun onItemClick(responseModel: ItemEntity) {
        val intent = Intent(this, ItemDetailActivity::class.java)
        intent.putExtra("image", responseModel.item_Img)
        intent.putExtra("title", responseModel.title)
        intent.putExtra("subTitle", responseModel.sub_Title)
        startActivity(intent)
    }
}