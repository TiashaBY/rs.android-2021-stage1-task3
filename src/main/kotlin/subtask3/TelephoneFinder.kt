package subtask3

class TelephoneFinder {

    private val neighboursPair = arrayListOf(
        "1" to arrayOf("2", "4"),
        "2" to arrayOf("1", "3", "5"),
        "3" to arrayOf("2", "6"),
        "4" to arrayOf("1", "5", "7"),
        "5" to arrayOf("2", "4", "6", "8"),
        "6" to arrayOf("3", "5", "9"),
        "7" to arrayOf("4", "8"),
        "8" to arrayOf("7", "5", "9", "0"),
        "9" to arrayOf("6", "8"),
        "0" to arrayOf("8")
    )

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        return if (number.toInt() < 0) {
            null
        } else {
            var result: Array<String> = emptyArray()
            for (i in number.indices) {
                result = result.plus(getReplacementAt(i, number))
            }
            result
        }
    }

    private fun getReplacementAt(pos: Int, string: String): Array<String> {
        val symbolToReplace = string[pos]
        val neighbours = neighboursPair.filter { it.first == symbolToReplace.toString() }.first().second
        return neighbours.map { string.replaceRange(pos, pos + 1, it) }.toTypedArray()
    }
}
