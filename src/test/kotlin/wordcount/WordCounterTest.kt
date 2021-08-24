package wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class WordCounterTest {
    @ParameterizedTest
    @CsvSource(
        "Mary had a little lamb, 5, 5",
        "Mary, 1, 1",
        " , 0, 0",
        "Maryhadalittlelamb, 1, 1",
        "wordWithUnknownCharacter#, 0, 0"
    )
    fun countsNumberOfWordsInATextLine(input: String?, expectedNumWords: Int, expectedUniqueCount: Int) {
        val nonNullInput = input ?: ""

        val actual = WordCounter.countWords(nonNullInput, emptyList())

        assertEquals(WordCountResult(expectedNumWords, expectedUniqueCount), actual)
    }

    @ParameterizedTest
    @CsvSource(
        "Mary had a little lamb, 4, 4",
        "Mary, 1, 1",
        " , 0, 0",
        "a a a off off, 0, 0",
        "Humpty-Dumpty sat on a wall., 4, 4",
        "Humpty-Dumpty had a great fall., 5, 5",
        "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall., 9, 7",
        "Pilot down. I repeat. pilot down, 6, 5"
    )
    fun countsNumberOfWordsExcludingStopWords(input: String?, expectedNumWords: Int, expectedUniqueCount: Int) {
        val nonNullInput = input ?: ""

        val actual = WordCounter.countWords(nonNullInput, StopwordsReader.getStopWords())

        assertEquals(WordCountResult(expectedNumWords, expectedUniqueCount), actual)
    }

}