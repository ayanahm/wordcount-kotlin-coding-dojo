package wordcount

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InputStreamSingleLineTextProviderTest {
    private val content = "Some hardcoded text"

    @Test
    fun `text from input stream is read`() {
        val bin =  content.byteInputStream()
        val textProvider = InputStreamSingleLineTextProvider(bin)

        assertEquals(content, textProvider.getText())
    }
}