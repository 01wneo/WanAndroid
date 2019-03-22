package com.chinamall21.mobile.kotlinstudy.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chinamall21.mobile.kotlinstudy.R.layout.item_rv_1
import com.chinamall21.mobile.kotlinstudy.R.layout.item_rv_2
import com.chinamall21.mobile.kotlinstudy.bean.TestBean
import kotlinx.android.synthetic.main.item_rv_1.view.*
import kotlinx.android.synthetic.main.item_rv_2.view.*


/**
 * desc：
 * author：Created by xusong on 2019/3/6 11:35.
 */

class TestAdapter(list:ArrayList<TestBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val TYPE_NORMAL = 1
    val TYPE_DATA = 2
    var mList :ArrayList<TestBean>?=null
    init {
        mList= list
    }
    override fun getItemCount() : Int{
        return mList!!.size
    }

    override fun getItemViewType(position: Int): Int {
        if(mList!!.get(position).type==1){
            return TYPE_NORMAL
        }else{
            return TYPE_DATA
        }
    }
    fun setNewData(list:ArrayList<TestBean>){
        mList =list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if(getItemViewType(position)==TYPE_NORMAL){
            var myholder:MyViewHolder2 = holder as MyViewHolder2
            myholder.setData(mList!!.get(position).data)
        }else{
            var myholder:MyViewHolder = holder as MyViewHolder
            myholder.setData(mList!!.get(position).data)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==TYPE_NORMAL){
            val itemView = LayoutInflater.from(parent!!.context).inflate(item_rv_2,parent,false)
            return MyViewHolder2(itemView)
        }else{
            val itemView = LayoutInflater.from(parent!!.context).inflate(item_rv_1,parent,false)
            return MyViewHolder(itemView)
        }

    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun setData(data: String){
            itemView.item_tv.setText(data)
        }
    }
    class MyViewHolder2(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun setData(data: String){
            itemView.item_tv_2.setText(data)
        }
    }
}