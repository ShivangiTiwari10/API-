package com.example.api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.mydataClass.Product
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(val context: Activity, val productArraylist: List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.my_api_items, parent, false)
        return MyViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = productArraylist[position]
        holder.title.text = currentItem.title
//        holder.image.setImageResource(currentItem.thumbnail)
    }

    override fun getItemCount(): Int {
        return productArraylist.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val title: TextView
        val image: ShapeableImageView

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)

        }
    }

}