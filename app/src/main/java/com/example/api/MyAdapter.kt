package com.example.api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.mydataClass.Product
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

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
        holder.ratingBar.rating = currentItem.rating.toFloat()

        Picasso.get().load(currentItem.thumbnail).into(holder.image)
    }

    override fun getItemCount(): Int {
        return productArraylist.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val title: TextView
        val image: ShapeableImageView
        val ratingBar: RatingBar

        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
            ratingBar = itemView.findViewById(R.id.ratingBar)

        }
    }

}