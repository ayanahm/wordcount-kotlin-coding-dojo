package wordcount

import java.nio.file.Path

class FileTextProvider(private val filePath: String) : InputTextProvider {
    override fun getText(): String {
        val filePath = Path.of(filePath)
        return filePath.toFile().readText()
    }
}