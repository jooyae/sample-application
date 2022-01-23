package org.android.reminiscencewinter.presentation.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import org.android.reminiscencewinter.R

object BindingAdapter {
    private const val HASH_TAG = "#"
    private const val SPACING = " "

    @JvmStatic
    @BindingAdapter("loadImageUrl")
    fun ImageView.loadImageUrl(url: String?) {
        url?.let {
            load(it){
                crossfade(true)
                placeholder(R.drawable.sharp_hourglass_top_black_1)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("loadCircleImageUrl")
    fun ImageView.loadCircleImageUrl(url: String?) {
        url?.let {
            load(it){
                transformations(CircleCropTransformation())
            }
        }
    }

    @JvmStatic
    @BindingAdapter("corner_radius")
    fun ShapeableImageView.setCornerRadius(radius: Float) {
    shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(radius)
    }

    @JvmStatic
    @BindingAdapter("setImageURL")
    fun ImageView.setImageURL(url: String?) {
        if(url == null) {
            background = ContextCompat.getDrawable(context, R.drawable.ic_launcher_background)
        } else {
            load(url)
        }
    }

    @JvmStatic
    @BindingAdapter("list_to_hash_tag")
    fun TextView.listToHashTagString(list: List<String>?){
        val hashTagList = list?.map { HASH_TAG + it }
        with(hashTagList) {
            text = if (list?.size ?: 0 <= 3) this?.joinToString(SPACING) else this?.subList(0, 3)?.joinToString(
                SPACING
            )
        }
    }
}
