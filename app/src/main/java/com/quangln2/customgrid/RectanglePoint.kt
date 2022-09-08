package com.quangln2.customgrid
class APoint(var x: Float, var y: Float) {
    fun set(x: Float, y: Float) {
        this.x = x
        this.y = y
    }
}

class RectanglePoint {
    lateinit var leftTop: APoint
    lateinit var rightBottom: APoint
    constructor(leftTop: APoint, rightBottom: APoint) {
        this.leftTop = leftTop
        this.rightBottom = rightBottom
    }
    constructor(left: Float, top: Float, right: Float, bottom: Float) {
        this.leftTop = APoint(left, top)
        this.rightBottom = APoint(right, bottom)
    }
}