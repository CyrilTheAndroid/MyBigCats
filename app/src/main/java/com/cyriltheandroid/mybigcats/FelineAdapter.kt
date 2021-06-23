package com.cyriltheandroid.mybigcats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FelineAdapter(
    private val felines: ArrayList<Feline>,
    private val listener: OnFelineClickListener
) : RecyclerView.Adapter<FelineAdapter.MyViewHolder>() {

    interface OnFelineClickListener {
        fun onFelineClicked(feline: Feline)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val felineImageView: ImageView = view.findViewById(R.id.feline_image)
        val felineNameTextView: TextView = view.findViewById(R.id.feline_name)
        val felinePaceTextView: TextView = view.findViewById(R.id.feline_pace)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.feline_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val feline = felines[position]
        holder.felineImageView.setImageResource(feline.resId)
        holder.felineNameTextView.text = feline.name
        holder.felinePaceTextView.text = ("${feline.pace} km/h")
        holder.itemView.setOnClickListener {
            listener.onFelineClicked(feline)
        }
    }

    override fun getItemCount(): Int = felines.size
}