package com.ligw.renld.adapter

import android.content.Intent
import android.net.Uri
import android.provider.DocumentsContract
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.ligw.renld.MainActivity
import com.ligw.renld.R
import com.ligw.renld.databinding.ItemMainBinding
import com.ligw.renld.entity.MainData


/**
 * @author created by ligw on 2022/8/8
 * @Email ligw@wanbu.com.cn
 */
class MainAdapter(var activity: MainActivity, var list: MutableList<MainData>): Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding:ItemMainBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var binding:ItemMainBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_main,
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.textView5.text = list.get(position).title
        holder.binding.textView6.text = list.get(position).desc
        holder.binding.imageView.setImageResource(list.get(position).bg)
        holder.binding.rlItem.setOnClickListener{
            activity.startPage(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

