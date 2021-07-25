package com.example.searchitemsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchitemsapp.R
import com.example.searchitemsapp.clicklistener.OnClickListener
import com.example.searchitemsapp.local.ItemEntity
import com.example.searchitemsapp.model.ResponseItem
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemAdapter(var responseList:List<ItemEntity>, val onItemClicked:OnClickListener):RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ItemViewHolder(onItemClicked,view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val responseItem:ItemEntity = responseList[position]
        holder.setItemView(responseItem)
    }

    override fun getItemCount(): Int {
       return responseList.size
    }

    fun updateItemList(responseList:List<ItemEntity>){
        this.responseList = responseList
        notifyDataSetChanged()
    }
}

class ItemViewHolder(val onItemClicked:OnClickListener,val view:View):RecyclerView.ViewHolder(view){
   fun setItemView(responseModel: ItemEntity){
       view.apply {
           tvTitle.text = responseModel.title
           tvDescription.text = responseModel.sub_Title
       }
       view.apply {
           Glide.with(ivItem).load(responseModel.item_Img).into(ivItem)
       }
       view.apply {
           clyItem.setOnClickListener {
               onItemClicked.onItemClick(responseModel)
           }
       }
   }
}