package com.ortega.posapp

fun main() {

}

fun getMiddle(word: String): String {

    var middleChar: String = word

    if (word.length == 1) {
        middleChar = word
    }

    if (word.length > 1) {
        middleChar = if (word.length % 2 == 0) {
            val middle = word.length / 2
            word[middle - 1].toString() + word[middle].toString()
        } else {
            val middle = word.length / 2
            word[middle].toString()
        }
    }

    return middleChar
}

fun highAndLow(numbers: String): String {

    val arr = numbers.split(" ").map { it.toInt() }
    return "${arr.maxOrNull()} ${arr.minOrNull()}"
}

fun smallEnough(a : IntArray, limit : Int) : Boolean {
    var check = true
    a.forEach {
        if (it > limit) {
            check = false
        }
    }

    return check
}

fun findShort(s: String) = s.split(" ").minWithOrNull(compareBy { it.length })?.count()

fun filterList(l: List<Any>): List<Int> {
    return l.filterIsInstance<Int>()
}

fun findScreenHeight(width: Int, ratio: String): String {
    val arr = ratio.split(":")
    val widthRatio = arr[0].toInt()
    val heightRatio = arr[1].toInt()

    val height = width * heightRatio / widthRatio
    return "${width}x${height}"
}

fun mirror(text: String) {
    val reversed = text.reversed()
    print(reversed)
}

object FileNameExtractor {
    fun extractFileName(dirtyFileName: String): String {
        val extract = dirtyFileName.split(".")
        return extract[0] + "." + extract[1]
    }
}