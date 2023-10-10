package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.data.PlaceListAdapter
import com.example.recyclerview.model.Place

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        var countryList: ArrayList<Place>?
        countryList = ArrayList()

        val countryNameList: Array<String> = arrayOf(
            "Canada", "Iran", "USA", "Columbia", "Spain", "Peru", "Italy", "India"
        )
        val citiesNameList: Array<String> = arrayOf(
            "Ottawa", "Tehran", "Washington", "Bogota", "Madrid", "Lima", "Rome", "Delhi"
        )

        for (i in 0..7) {
            val place = Place().apply {
                countryName = countryNameList[i]
                cityName = citiesNameList[i]
            }
            countryList.add(place)
        }

        var adapter: PlaceListAdapter?
        var linearLayoutManager: RecyclerView.LayoutManager?

        linearLayoutManager = LinearLayoutManager(this)
        adapter = PlaceListAdapter(countryList, this)

        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }
}