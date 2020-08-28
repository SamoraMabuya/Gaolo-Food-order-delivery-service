package com.example.deliver.customer

import android.graphics.ColorSpace
import android.icu.util.ULocale
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deliver.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.recycler_view.*


class Restaurants : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var ref: DatabaseReference
    lateinit var sellers: MutableList<Merchants>
    lateinit var adapter: MerchantAdapter

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurants)

        recyclerView = findViewById(R.id.merchantListing)
        ref = FirebaseDatabase.getInstance().getReference("Restaurants")

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        sellers = mutableListOf()

        adapter = MerchantAdapter(this, sellers)
        merchantListing.adapter = adapter
        merchantListing.layoutManager = LinearLayoutManager(this)





    }
}
