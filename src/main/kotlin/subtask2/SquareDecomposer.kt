package subtask2

import kotlin.math.sqrt

class SquareDecomposer {

    var isFound: Boolean = false

    fun decomposeNumber(number: Int): Array<Int>? {
        if (number <= 0) return null
        val numberArray: MutableList<Long> = mutableListOf()
        for (i in 1 until number) {
            numberArray.add(i * i.toLong())
        }
        val resultArray: MutableList<Long> = mutableListOf()
        getCombinations(numberArray.size - 1, 0, number * number.toLong(), resultArray, numberArray)
        return if (resultArray.isNotEmpty()) {
            resultArray.map { sqrt(it.toDouble()).toInt() }.reversed().toTypedArray()
        } else
            null
    }

    private fun getCombinations(
        l: Int, sum: Long, K: Long,
        local: MutableList<Long>,
        numberArray: MutableList<Long>
    ) {
        if (sum == K) {
            isFound = true
            return
        }
        // For all other combinations
        for (i in l downTo 0) {
            // Check if the sum exceeds K
            if (sum + numberArray[i] > K) continue
            // Take the element into the combination
            local.add(numberArray[i])
            getCombinations(
                i - 1, sum + numberArray[i], K,
                local, numberArray
            )

            if (isFound) {
                return
            } else {
                local.removeAt(local.size - 1)
            }
        }
    }
}



