package com.cyriltheandroid.mybigcats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var felinesRecyclerView: RecyclerView
    private val felines = arrayListOf(
        Feline("Tigre", 64, R.drawable.tigre),
        Feline("Lion", 80, R.drawable.lion),
        Feline("Lynx", 70, R.drawable.lynx),
        Feline("Cougar", 80, R.drawable.cougar),
        Feline("Chat", 48, R.drawable.chat),
        Feline("Jaguar", 80, R.drawable.jaguar),
        Feline("Leopard", 58, R.drawable.leopard),
        Feline("Guepard", 130, R.drawable.guepard)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        felinesRecyclerView = findViewById(R.id.felines_recycler_view)
        felinesRecyclerView.apply {
            adapter = FelineAdapter(felines, object: FelineAdapter.OnFelineClickListener {
                override fun onFelineClicked(feline: Feline) {
                    /*val intent: Intent = Intent(this@MainActivity, FelineDetailsActivity::class.java)
                    intent.putExtra("FELINE_NAME", feline.name)
                    startActivity(intent)*/
                    Log.d("MainActivity", "Le ${feline.name} est capable d'aller à une vitesse de ${feline.pace} km/h !")
                }
            })
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}