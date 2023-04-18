package com.example.api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.mydataClass.Product

class MyAdapter(private val myArrayList: ArrayList<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_api_items, parent, false)
        return MyViewHolder(view)
        
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = myArrayList[position]
        holder.textTittle.text= currentItem.title
        holder.textDiscription.text = currentItem.description
        holder.profile.setImageResource(currentItem.images.size)
    }

    override fun getItemCount(): Int {
        return  myArrayList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val textTittle: TextView = itemView.findViewById(R.id.texTitle)
        val textDiscription:TextView = itemView.findViewById(R.id.textDiss)
        val profile: ImageView = itemView.findViewById(R.id.imageView)
    }
}
