package subtask1

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        var m = array[0]
        val n = array[1]
        var x: Int? = null
        for (i in 1..n) {
            if (Int.choose(n, i) == m) {
                x = i
                break
            }
        }
        return x
    }
}

private fun Int.Companion.choose(n: Int, k: Int): Int {
    var numerator: Long = 1
    var denominator: Long = 1
    for (i in n downTo n - k + 1) {
        numerator *= i
    }
    for (i in k downTo 1) {
        denominator *= i
    }
    return (numerator / denominator).toInt()
}
