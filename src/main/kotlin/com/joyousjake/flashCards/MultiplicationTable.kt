package com.joyousjake.flashCards

import java.util.Random

class MultiplicationTable(val size: Int) {

    fun product(a: Int, b: Int) = if (a in 2..size && b in 2..size) a * b
        else throw Exception()

    val randomInteger: Int
        get() = (2..size).random()

    override fun toString(): String = "The size of the table is $size by $size"

    fun ClosedRange<Int>.random() = Random().nextInt(endInclusive + 1 - start) + start
}
