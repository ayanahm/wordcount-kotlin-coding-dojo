package wordcount

import java.util.regex.Pattern

object WordCounter {
    private val regex = Pattern.compile("[a-zA-Z]+").toRegex()

    fun countWords(text: String, stopwords: List<String>): WordCountResult {
        val tokens = splitText(text, "[ _\\-.]+".toRegex())
        val words = tokens
            .filter { w -> isAWord(w) }
            .filter { w -> w !in stopwords }

        return WordCountResult(
            numWords = words.size,
            unique = words.toSet().size
        )
    }

    private fun isAWord(text: String): Boolean {
        return text.matches(regex)
    }

    private fun splitText(text: String, delimiterPattern: Regex): List<String> {
        return text.split(delimiterPattern)
    }
}

data class WordCountResult(
    val numWords: Int,
    val unique: Int
)
