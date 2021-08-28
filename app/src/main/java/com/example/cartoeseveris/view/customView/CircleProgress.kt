package com.example.cartoeseveris.view.customView

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cartoeseveris.R

class CircleProgress  {
//    enum class TypeProgress {
//        DEFAULT, PARCIAL, OVERBALANCE
//    }
//
//    constructor(context: Context) : super(context) {
//        initViews(context)
//    }
//
//    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
//        initViews(context)
//    }
//
//    constructor(context: Context, attrs: AttributeSet?, styleAttr: Int) : super(
//        context,
//        attrs,
//        styleAttr
//    ) {
//        initViews(context)
//    }
//
//    lateinit var defaultProgress: ProgressBar
//    lateinit var parcialProgress: ProgressBar
//    lateinit var overbalance: ProgressBar
//    lateinit var tvPercentage: AppCompatTextView
//    private lateinit var progress: ProgressBar
//
//
//    private fun setViewProgress(type: TypeProgress) {
//        when (type) {
//            TypeProgress.DEFAULT -> {
//                progress = defaultProgress
//                defaultProgress.visibility = View.VISIBLE
//            }
//            TypeProgress.PARCIAL -> {
//                progress = parcialProgress
//                parcialProgress.visibility = View.VISIBLE
//            }
//            TypeProgress.OVERBALANCE -> {
//                progress = overbalance
//                overbalance.visibility = View.VISIBLE
//            }
//        }
//    }
//
//    private fun setContents(used: Int, total: Int, isUnlimitedTotal: Boolean) {
//        tvPercentage.text = used.toString()
//        progress.max = 100
//        if (isUnlimitedTotal) {
//            setViewProgress(TypeProgress.DEFAULT)
//            progress.progress = 0
//            tvPercentage.text = context.getString(R.string.tv_unlimited_progress_bar)
//            return
//        } else if (used == 0 || used == total) {
//            setViewProgress(TypeProgress.DEFAULT)
//            progress.max = total
//            progress.progress = used
//        } else if (used > total) {
//            setViewProgress(TypeProgress.OVERBALANCE)
//            progress.progress = 100
//        } else {
//            setViewProgress(TypeProgress.PARCIAL)
//            progress.max = total
//            progress.progress = used
//        }
//        tvPercentage.text = context.getString(R.string.tv_item).plus(total)
//    }
//
//    private fun initViews(context: Context) {
//        val view = View.inflate(context, R.layout.layout_item_progress_card, this)
//        defaultProgress = view.findViewById<View>(R.id.progress_card_default) as ProgressBar
//        parcialProgress = view.findViewById<View>(R.id.progress_card_parcial) as ProgressBar
//        overbalance = view.findViewById<View>(R.id.progress_card_overbalance) as ProgressBar
//        tvPercentage = view.findViewById(R.id.tv_balance_usage_card)
//    }
//
//    fun setValues(used: Int, total: Int = 0, isUnlimitedTotal: Boolean = false) {
//        setContents(used, total, isUnlimitedTotal)
//    }
}