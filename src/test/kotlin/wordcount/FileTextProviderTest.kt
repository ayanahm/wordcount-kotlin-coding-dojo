package wordcount

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException
import kotlin.test.assertEquals

internal class FileTextProviderTest {
    private val filePath = "testdata/input1.txt"
    private val nonExistingFilePath = "someFileNotPresent"

    @Test
    fun `content of the file from project root is read`() {
        val textProvider = FileTextProvider(filePath)

        val text = textProvider.getText()

        assertEquals("mary had a little lamb", text)
    }

    @Test
    fun `file not found results in a readable error`() {
        val textProvider = FileTextProvider(nonExistingFilePath)

        assertThrows<FileNotFoundException> { textProvider.getText()}
    }
}