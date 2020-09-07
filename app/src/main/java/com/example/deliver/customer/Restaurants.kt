package com.example.deliver.customer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliver.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.recycler_view.*


class Restaurants : AppCompatActivity() {


    private val db: FirebaseFirestore = FirebaseFirestore.getInstance();
    private val collectionReference: CollectionReference = db.collection("Restaurants");

    var userAdapter: UserAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
        setUpRecyclerview()
    }

    fun setUpRecyclerview() {
        val query: Query = collectionReference;
        val firestoreRecyclerOptions: FirestoreRecyclerOptions<Merchants> =
            FirestoreRecyclerOptions.Builder<Merchants>()
                .setQuery(query, Merchants::class.java)
                .build();

        userAdapter = UserAdapter(firestoreRecyclerOptions)
        merchantListing.layoutManager = LinearLayoutManager(this)
        merchantListing.adapter = userAdapter

    }

    override fun onStart() {
        super.onStart()
        userAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        userAdapter!!.stopListening()
    }
}






