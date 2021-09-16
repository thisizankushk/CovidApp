package com.example.covid19_tracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val context: Context, val statewise: List<statewise>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val statewise = statewise[position]
        holder.state.text = statewise.state
        holder.total.text = statewise.confirmed
        holder.active.text = statewise.active
        holder.recovered.text = statewise.recovered
        holder.death.text = statewise.deaths


    }

    override fun getItemCount(): Int {
        return statewise.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var state: TextView = itemView.findViewById(R.id.State)
        var total: TextView = itemView.findViewById(R.id.total)
        var active: TextView = itemView.findViewById(R.id.active)
        var recovered: TextView = itemView.findViewById(R.id.recovered)
        var death: TextView = itemView.findViewById(R.id.death)


    }

}
