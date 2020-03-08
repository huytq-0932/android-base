package com.tr4n.androidbase.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.tr4n.androidbase.R
import com.tr4n.androidbase.data.model.Photo
import com.tr4n.base.view.recyclerview.BaseRecyclerAdapter
import com.tr4n.base.view.recyclerview.BaseViewHolder
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapter(
    private val onItemSelected: (Photo, Int) -> Unit = { _, _ -> }
) : BaseRecyclerAdapter<Photo, PhotoViewHolder>(PhotoDiffUtilCallback()) {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_photo

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val itemView = getItemView(parent, viewType)
        return PhotoViewHolder(itemView, onItemSelected)
    }

    class PhotoDiffUtilCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
            oldItem == newItem
    }
}

class PhotoViewHolder(
    itemView: View,
    onItemSelected: (Photo, Int) -> Unit
) : BaseViewHolder<Photo>(itemView) {

    init {
        itemView.setOnClickListener {
            itemData?.let {
                onItemSelected(it, adapterPosition)
            }
        }
    }

    override fun onBindData(itemData: Photo) {
        super.onBindData(itemData)
        Glide.with(itemView.context).load(itemData.url).into(itemView.imagePhoto)
    }
}
