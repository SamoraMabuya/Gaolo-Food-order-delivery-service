package com.example.deliver.customer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliver.R
import kotlinx.android.synthetic.main.restaurants.view.*

class MerchantAdapter (private val context: Context, private val sellers: List<Merchants>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.restaurants, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = sellers.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.bind(sellers[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    }

     fun RecyclerView.ViewHolder.bind(merchants: Merchants) {
         itemView.merchTitle.text = merchants.name
         itemView.hours.text = merchants.hours
         itemView.phone.text = merchants.phone
         Glide.with(context).into(itemView.SpathloImage)


}

