package com.billing

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.android.billingclient.api.SkuDetails

class ProductsAdapter(
    private val list: List<SkuDetails>,
    private val onProductClicked: (SkuDetails) -> Unit
) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false) as TextView
        val viewHolder = ViewHolder(textView)
        textView.setOnClickListener { onProductClicked(list[viewHolder.adapterPosition]) }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = list[position].title
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}