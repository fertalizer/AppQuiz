package com.mark.appquiz

import android.opengl.Visibility
import android.util.EventLogTags
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mark.appquiz.data.OverviewData
import com.mark.appquiz.overview.OverViewAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<OverviewData>?) {
    val adapter = recyclerView.adapter as OverViewAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_baseline_person_24)
                    .error(R.drawable.ic_baseline_close_24)
            )
            .into(imageView)
    }
}

@BindingAdapter("tag")
fun bindTags(textView: TextView, tag: String) {
    tag?.let {
        textView.visibility = View.VISIBLE
        textView.text = it
    }
}

@BindingAdapter("Int")
fun bindIntToText(textView: TextView, number: Int) {
    val text = number.toString()
    textView.text = text
}

