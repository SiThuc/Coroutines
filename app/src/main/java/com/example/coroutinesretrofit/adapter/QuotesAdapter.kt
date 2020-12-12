package com.example.coroutinesretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesretrofit.R
import com.example.coroutinesretrofit.databinding.ItemQuoteBinding
import com.example.coroutinesretrofit.model.Quote

class QuotesAdapter(var quotes: List<Quote>) : RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder>() {


    inner class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text_quote: TextView? = null
        var text_author: TextView? = null

        init {
            text_quote = itemView.findViewById(R.id.text_view_quote) as TextView
            text_author = itemView.findViewById(R.id.text_view_author) as TextView
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        )
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.text_quote!!.text = quotes!!.get(position).quote
        holder.text_author!!.text = quotes!!.get(position).author

    }

    override fun getItemCount() = quotes?.size ?: 0

}