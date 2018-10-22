package com.joyousjake.flashCards


fun main(args: Array<String>) {
    print("Enter the size of the multiplication table (Default: 12; 12x12) ")
    val table = readInt()
    print("The size of the table is $table by $table")

}

fun readInt(): Int {
    val s = readLine()
    return when  {
        s == null || Regex("[^0-9]*").matches(s) -> 12
        else -> s.toInt()
    }
}
