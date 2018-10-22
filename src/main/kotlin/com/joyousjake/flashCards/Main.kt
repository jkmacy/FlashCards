package com.joyousjake.flashCards


fun main(args: Array<String>) {
    print("Enter the size of the multiplication table (Default: 12; 12x12) ")
    val table = readInt()
    print("The size of the table is $table by $table")

}

fun readInt(): Int {
    val s = readLine()
    val i: String = when  {
        s == null -> "12"
        Regex("[a-zA-Z]*").containsMatchIn(s) -> "12"
        else -> s
    }
    var r: Int
    do {
        try {
            r = i.toInt()
        }
        catch (e: NumberFormatException) {
            continue
        }
        break
    } while (true)
    return r
}
