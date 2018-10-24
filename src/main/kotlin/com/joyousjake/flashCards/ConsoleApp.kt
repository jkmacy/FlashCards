package com.joyousjake.flashCards

const val tablePrompt = "Enter the size of the multiplication table [Default - 12 (12x12); table size should be min of 3]: "

fun main(args: Array<String>) {
    print(tablePrompt)
    var size = readInt()
    while (size < 3) {
        print("The table size should at least be 3: ")
        size = readInt()
    }

    var table = MultiplicationTable(size)
    println("$table\n")

    var promptAnswer: Char
    loop@ while (true) {
        val (a, b) = Pair(table.randomInteger, table.randomInteger)
        val correctAnswer = table.product(a, b)
        print("$a x $b = ")
        val yourAnswer = readInt()
        println()

        if (yourAnswer == correctAnswer)
            println("Your answer was correct!")
        else
            println("Sorry, the correct answer was $correctAnswer")

        print("""
            |Do you want to answer another problem?
            |[Y (Yes), n (no), m (new multiplication table)]
        """.trimMargin() + " ")
        val line = readLine()
        promptAnswer = if (line != null && line.isNotEmpty()) line[0].toLowerCase() else 'y'
        println()

        when (promptAnswer) {
            'y' -> continue@loop
            'n' -> {
                println("Exiting program...")
                break@loop
            }
            'm' -> {
                print(tablePrompt)
                table = MultiplicationTable(readInt())
                println("$table\n")
                continue@loop
            }
            else -> {
                println("Entered an invalid option, exiting program...")
                break@loop
            }
        }
    }
}

fun readInt(): Int {
    val s = readLine()
    return when  {
        s == null || Regex("[^0-9]*").matches(s) -> -1
        else -> s.toInt()
    }
}
