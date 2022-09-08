package com.quangln2.customgrid

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomGrid: View {
    private val numberOfImages = 5
    private val rectangles = mutableListOf<RectanglePoint>()
    private val myPaint = Paint().apply {
        color = Color.RED
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    constructor(context: Context): super(context) {

    }

    constructor(context: Context, attrs: AttributeSet): super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr) {}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val frameSize = minOf(widthMeasureSpec, heightMeasureSpec)
        super.onMeasure(frameSize, frameSize)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {

        if(numberOfImages == 1){
            val largeRectangle = RectanglePoint(0f,0f, width.toFloat(), width.toFloat())
            rectangles.add(largeRectangle)
        } else if(numberOfImages <= 4){
            val largeRectangle = RectanglePoint(0f,0f, width.toFloat() / 2, width.toFloat())
            val left = width.toFloat() / 2
            val right = width.toFloat()

            rectangles.add(largeRectangle)
            val remainingRectangles = numberOfImages - 1
            for (i in 0 until remainingRectangles){
                val top = i * (width.toFloat() / remainingRectangles)
                val bottom = (i + 1) * (width.toFloat() / remainingRectangles)
                rectangles.add(RectanglePoint(left, top, right, bottom))
            }
        } else if(numberOfImages == 5){
            val firstRect = RectanglePoint(0f,0f, width.toFloat() / 2, 2 * width.toFloat() / 3)
            val secondRect = RectanglePoint(width.toFloat() / 2,0f, width.toFloat(), 2 * width.toFloat() / 3)
            val top = 2 * width.toFloat() / 3
            val bottom = width.toFloat()

            for(i in 0 until 3){
                val left = i * (width.toFloat() / 3)
                val right = (i + 1) * (width.toFloat() / 3)
                rectangles.add(RectanglePoint(left, top, right, bottom))
            }
            rectangles.add(firstRect)
            rectangles.add(secondRect)
        } else if(numberOfImages == 6){
            val firstRect = RectanglePoint(0f,0f, 2*width.toFloat() / 3, 2 * width.toFloat() / 3)
            val secondRect = RectanglePoint(2*width.toFloat() / 3,0f, width.toFloat(), 1 * width.toFloat() / 3)
            val thirdRect = RectanglePoint(2*width.toFloat() / 3,1*width.toFloat() / 3, width.toFloat(), 2 * width.toFloat() / 3)
            val top = 2 * width.toFloat() / 3
            val bottom = width.toFloat()
            for(i in 0 until 3){
                val left = i * (width.toFloat() / 3)
                val right = (i + 1) * (width.toFloat() / 3)
                rectangles.add(RectanglePoint(left, top, right, bottom))
            }
            rectangles.add(firstRect)
            rectangles.add(secondRect)
            rectangles.add(thirdRect)
        } else if(numberOfImages == 7){
            val firstRect = RectanglePoint(0f,0f, 2*width.toFloat() / 3, 1 * width.toFloat() / 3)
            val firstOfFirstRect = RectanglePoint(0f, width.toFloat() / 3, 2*width.toFloat() / 3, 2 * width.toFloat() / 3)
            val secondRect = RectanglePoint(2*width.toFloat() / 3,0f, width.toFloat(), 1 * width.toFloat() / 3)
            val thirdRect = RectanglePoint(2*width.toFloat() / 3,1*width.toFloat() / 3, width.toFloat(), 2 * width.toFloat() / 3)
            val top = 2 * width.toFloat() / 3
            val bottom = width.toFloat()
            for(i in 0 until 3){
                val left = i * (width.toFloat() / 3)
                val right = (i + 1) * (width.toFloat() / 3)
                rectangles.add(RectanglePoint(left, top, right, bottom))
            }
            rectangles.add(firstRect)
            rectangles.add(firstOfFirstRect)
            rectangles.add(secondRect)
            rectangles.add(thirdRect)
        } else if(numberOfImages == 8){
            val largestRect = RectanglePoint(0f,0f, 1*width.toFloat() / 3, 2 * width.toFloat() / 3)
            val firstRect = RectanglePoint(width.toFloat() / 3,0f, 2*width.toFloat() / 3, 1 * width.toFloat() / 3)
            val firstOfFirstRect = RectanglePoint(width.toFloat() / 3, width.toFloat() / 3, 2*width.toFloat() / 3, 2 * width.toFloat() / 3)
            val secondRect = RectanglePoint(2*width.toFloat() / 3,0f, width.toFloat(), 1 * width.toFloat() / 3)
            val thirdRect = RectanglePoint(2*width.toFloat() / 3,1*width.toFloat() / 3, width.toFloat(), 2 * width.toFloat() / 3)
            val top = 2 * width.toFloat() / 3
            val bottom = width.toFloat()
            for(i in 0 until 3){
                val left = i * (width.toFloat() / 3)
                val right = (i + 1) * (width.toFloat() / 3)
                rectangles.add(RectanglePoint(left, top, right, bottom))
            }
            rectangles.add(largestRect)
            rectangles.add(firstRect)
            rectangles.add(firstOfFirstRect)
            rectangles.add(secondRect)
            rectangles.add(thirdRect)
        } else if(numberOfImages == 9){
            for(k in 0 until 3){
                val top = k * width.toFloat() / 3
                val bottom = (k+1) * width.toFloat() /3
                for(i in 0 until 3){
                    val left = i * (width.toFloat() / 3)
                    val right = (i + 1) * (width.toFloat() / 3)
                    rectangles.add(RectanglePoint(left, top, right, bottom))
                }
            }
        }

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.foodie)

        rectangles.forEach {
            canvas?.drawBitmap(bitmap, null, Rect(it.leftTop.x.toInt(), it.leftTop.y.toInt(), it.rightBottom.x.toInt(), it.rightBottom.y.toInt()), null)
        }
        super.onDraw(canvas)
    }
}