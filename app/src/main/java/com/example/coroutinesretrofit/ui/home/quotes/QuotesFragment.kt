package com.example.coroutinesretrofit.ui.home.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesretrofit.R
import com.example.coroutinesretrofit.adapter.QuotesAdapter
import com.example.coroutinesretrofit.databinding.FragmentQuotesBinding

class QuotesFragment : Fragment() {

    private lateinit var quotesAdapter:QuotesAdapter
    private lateinit var quoteViewModel: QuotesViewModel

    private var recycler_quote: RecyclerView? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val itemView = LayoutInflater.from(context).inflate(R.layout.fragment_quotes, container, false)
        initViews(itemView)

        return itemView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        quoteViewModel = ViewModelProvider(this).get(QuotesViewModel::class.java)

        quoteViewModel.quotes.observe(viewLifecycleOwner, Observer {
            quotesAdapter = QuotesAdapter(it)
            quotesAdapter.notifyDataSetChanged()
            recycler_quote!!.adapter = quotesAdapter

        })
//        quoteViewModel.quotes.observe(viewLifecycleOwner, Observer {
//            quotesAdapter.quotes = it
//        })
    }

    private fun initViews(itemView: View?) {
        quoteViewModel = ViewModelProvider(this).get(QuotesViewModel::class.java)

        recycler_quote = itemView!!.findViewById(R.id.recyclerview_quotes) as RecyclerView

        recycler_quote!!.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
        recycler_quote!!.layoutManager = layoutManager

        recycler_quote!!.addItemDecoration(
                DividerItemDecoration(
                        requireContext(),
                        layoutManager.orientation
                )
        )

    }
}