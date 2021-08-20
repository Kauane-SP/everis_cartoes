package com.example.cartoeseveris.fragments

import android.animation.ArgbEvaluator
import android.content.Context
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cartoeseveris.R

class CarroselCartoes(
    context: Context,
    attrs: AttributeSet
) : RecyclerView(context, attrs) {

    private val activeColor
            by lazy { ContextCompat.getColor(context, R.color.blue) }
    private val inactiveColor
            by lazy { ContextCompat.getColor(context, R.color.black) }
    private var viewsToChangeColor = listOf<Int>()

    fun setViewsToChangeColor(viewIds: List<Int>) {
        viewsToChangeColor = viewIds
    }

    fun <T : ViewHolder> initialize(newAdapter: Adapter<T>) {
        layoutManager = LinearLayoutManager(context, HORIZONTAL, false)
        newAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                post {
                    val sidePadding = (width / 10) - (getChildAt(1).width / 10)
                    setPadding(sidePadding, 2, sidePadding, 2)
                    scrollToPosition(0)
                    addOnScrollListener(object : OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx * 4, dy * 6)
                            onScrollChanged()
                        }
                    })
                }
            }
        })
        adapter = newAdapter
    }

    private fun onScrollChanged() {
        post {
            (0 until childCount).forEach { position ->
                val child = getChildAt(position)
                val childCenterX = (child.left + child.right) / 2
                val scaleValue = getGaussianScale(childCenterX, 0.8f, 0.4f, 180.toDouble())
                child.scaleX = scaleValue
                child.scaleY = scaleValue
                colorView(child, scaleValue)
            }
        }
    }

    private fun getGaussianScale(
        childCenterX: Int,
        minScaleOffest: Float,
        scaleFactor: Float,
        spreadFactor: Double
    ): Float {
        val recyclerCenterX = (left + right) / 2
        return (Math.pow(
            Math.E,
            -Math.pow(childCenterX - recyclerCenterX.toDouble(), 2.toDouble()) / (4 * Math.pow(
                spreadFactor,
                2.toDouble()
            ))
        ) * scaleFactor + minScaleOffest).toFloat()
    }

    private fun colorView(child: View, scaleValue: Float) {
        val saturationPercent = (scaleValue - 1) / 1f
        val alphaPercent = scaleValue / 1f
        val matrix = ColorMatrix()
        matrix.setSaturation(saturationPercent)

        viewsToChangeColor.forEach { viewId ->
            val viewToChangeColor = child.findViewById<View>(viewId)
            when (viewToChangeColor) {
                is ImageView -> {
                    viewToChangeColor.colorFilter = ColorMatrixColorFilter(matrix)
                    viewToChangeColor.imageAlpha = (255 * alphaPercent).toInt()
                }
                is TextView -> {
                    val textColor = ArgbEvaluator().evaluate(
                        saturationPercent,
                        inactiveColor,
                        activeColor
                    ) as Int
                    viewToChangeColor.setTextColor(textColor)
                }
            }
        }
    }
}