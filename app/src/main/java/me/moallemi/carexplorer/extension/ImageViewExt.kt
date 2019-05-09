package me.moallemi.carexplorer.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Picasso
import me.moallemi.carexplorer.R

fun ImageView.load(url: String?, @DrawableRes placeHolder: Int) {
    Picasso.get()
        .load(url)
        .placeholder(placeHolder)
        .error(R.drawable.ic_error_black_24dp)
        .into(this)
}