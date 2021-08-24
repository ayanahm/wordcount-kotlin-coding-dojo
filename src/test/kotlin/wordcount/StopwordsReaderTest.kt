package wordcount

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class StopwordsReaderTest {

    @Test
    fun `all stopwords from file are read`() {
        val stopWords = StopwordsReader.getStopWords()

        val expected = listOf(
            "the", "a", "on", "off"
        )

        assertEquals(expected, stopWords)
    }
}