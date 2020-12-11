package com.example.appresep

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.activity_recycle_view_template, parent, false)) {

    private var imgView: ImageView? = null
    private var txtTitle: TextView? = null
    private var txtSubTitle: TextView? = null

    init {
        imgView = itemView.findViewById(R.id.img_view)
        txtTitle = itemView.findViewById(R.id.txt_tittle)
        txtSubTitle = itemView.findViewById(R.id.txt_sub_tittle)
    }

    fun bind(data: Resep){
        imgView?.setImageResource(data.imgView)
        txtTitle?.text = data.txtTitle
        txtSubTitle?.text = data.txtSubTitle
    }
}