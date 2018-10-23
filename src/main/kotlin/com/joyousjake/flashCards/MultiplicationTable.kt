package com.joyousjake.flashCards


class MultiplicationTable(val size: Int) {

    fun product(a: Int, b: Int) = if (a in 1..size && b in 1..size) a * b
        else throw Exception()

    override fun toString(): String = "The size of the table is $size by $size"

}
