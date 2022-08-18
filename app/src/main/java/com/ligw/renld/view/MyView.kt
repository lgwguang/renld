package com.ligw.renld.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.withTranslation
import com.ligw.renld.R

/**
 * @author created by ligw on 2022/8/15
 * @Email ligw@wanbu.com.cn
 */
class MyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var paint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 2.0f
        color = ContextCompat.getColor(context, R.color.black)
    }

    private var paintCircle = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 2.0f
        isAntiAlias = true
        pathEffect = DashPathEffect(floatArrayOf(10f,10f),0f)
        color = ContextCompat.getColor(context,R.color.teal_200)
    }

    private var mWidth: Float = 0f
    private var mHeight: Float = 0f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat()
        mHeight = h.toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            drawAxises(this)
            drawText(this)
        }

    }

    private fun drawText(canvas: Canvas) {
        paint.apply {
            textSize = 20f
        }
        canvas.drawText("中国北京",100F,100F,paint)
    }

    fun drawAxises(canvas: Canvas) {
        canvas.withTranslation(mWidth / 2, mHeight / 2) {
            drawLine(-mWidth / 2, 0f, mWidth / 2, 0f, paint)
            drawLine(0f, -mHeight / 2, 0f, mHeight / 2, paint)
        }
        canvas.withTranslation(mWidth / 2, mHeight * 3 / 4) {
            drawLine(-mWidth / 2, 0f, mWidth / 2, 0f, paint)
        }

        canvas.withTranslation(mWidth / 2, mHeight * 3 / 4) {
            drawCircle(0f,0f,mHeight/4 - 20 ,paintCircle)
        }
//        canvas.drawBitmap()
        var icon = BitmapDrawable()
    }
}