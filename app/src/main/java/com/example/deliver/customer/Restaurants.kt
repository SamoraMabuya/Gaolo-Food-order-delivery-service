package com.example.deliver.customer

import android.os.Build
import android.os.Bundle
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
    lateinit var thisRef: DatabaseReference
//    lateinit var thisAdapter: MutableList<Merchants>
    lateinit var thisManager: RecyclerView.LayoutManager
    lateinit var adapter: MerchantAdapter
    private lateinit var thisAdapter: List<Merchants>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurants)

        recyclerView = findViewById(R.id.merchantListing)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        thisRef = FirebaseDatabase.getInstance().getReference("Restaurants")

        adapter = MerchantAdapter(this, thisAdapter)


//        sellers = mutableListOf()
//
//        adapter = MerchantAdapter(this, sellers)
//        merchantListing.adapter = adapter
//        merchantListing.layoutManager = LinearLayoutManager(this)
//
//        val options: FirebaseRecyclerOptions<Merchants> = FirebaseRecyclerOptions.Builder<Merchants>()
//            .setQuery(query, Merchants::class.java)
//            .build()
//
//        val adapter: FirebaseRecyclerAdapter = FirebaseRecyclerAdapter<Merchants>
//
//
//
//    }
}
