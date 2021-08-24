package wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WordCounterTest {
    @ParameterizedTest
    @CsvSource(
        "Mary had a little lamb, 5",
        "Mary, 1",
        " , 0",
        "Maryhadalittlelamb, 1",
        "wordWithUnknownCharacter#, 0",
        "word_WithUnknownCharacter, 0"
    )
    fun countsNumberOfWordsInATextLine(input: String?, expected: Int) {
        val nonNullInput = input ?: ""

        val actual = WordCounter.countWords(nonNullInput, emptyList())

        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @CsvSource(
        "Mary had a little lamb, 4",
        "Mary, 1",
        " , 0",
        "a a a off off, 0",
    )
    fun countsNumberOfWordsExcludingStopWords(input: String?, expected: Int) {
        val nonNullInput = input ?: ""

        val actual = WordCounter.countWords(nonNullInput, StopwordsReader.getStopWords())

        assertEquals(expected, actual)
    }

}