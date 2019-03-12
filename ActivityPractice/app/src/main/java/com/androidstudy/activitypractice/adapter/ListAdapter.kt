package com.androidstudy.activitypractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.androidstudy.activitypractice.R
import kotlinx.android.synthetic.main.list_item.view.*

class ListAdapter(val layoutInflater: LayoutInflater) : BaseAdapter() {
    val items = listOf(
        "123",
        "456",
        "789",
        "101112",
        "131415",
        "123",
        "456",
        "789",
        "101112",
        "131415",
        "123",
        "456",
        "789",
        "101112",
        "131415",
        "123",
        "456",
        "789",
        "101112",
        "131415"
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.list_item,null)
        view.tv_list_item.text= items[position]
        return view
    }

    override fun getItem(position: Int)= items[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = items.size //kotlin은 return 굳이 안해줘도 됨.

}