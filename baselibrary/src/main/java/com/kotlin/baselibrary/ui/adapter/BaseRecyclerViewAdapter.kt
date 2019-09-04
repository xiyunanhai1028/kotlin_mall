package com.kotlin.baselibrary.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView

/**
 *    author : dufeihu
 *    date   : 2019/9/3 10:47
 *    desc   :
 */
abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(var context: Context) :
    RecyclerView.Adapter<VH>() {

    //事件监听
    var onItemClickListener: OnItemClickListener<T>? = null
    //数据
    var listData: MutableList<T> = mutableListOf()

    //设置数据
    fun setData(source: MutableList<T>) {
        listData = source
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.setOnClickListener {
            if (onItemClickListener != null) {
                onItemClickListener!!.onItemClick(listData[position], position)
            }
        }
    }

    interface OnItemClickListener<in T> {
        fun onItemClick(item: T, position: Int)
    }

    fun setOnItemtClickListener(listener: OnItemClickListener<T>) {
        onItemClickListener = listener
    }
}