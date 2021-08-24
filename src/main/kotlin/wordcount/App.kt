package wordcount

import java.io.InputStream
import java.io.OutputStream

class App(
    private val inStream: InputStream?,
    private val outStream: OutputStream
) {
    fun run(programArgs: Array<String>) {
        val inputTextProvider:InputTextProvider = createInputTextProvider(programArgs)
        val count = WordCounter.countWords(inputTextProvider.getText(), StopwordsReader.getStopWords())

        outStream
            .bufferedWriter()
            .use { bw -> bw.write(outputString(count)) }
    }

    private fun outputString(result: WordCountResult) = "Number of words: ${result.numWords}, unique: ${result.unique}"

    private fun createInputTextProvider(programArgs: Array<String>): InputTextProvider {
        return if (programArgs.isNotEmpty()) {
            FileTextProvider(programArgs[0])
        } else {
            InputStreamSingleLineTextProvider(inStream ?: throw IllegalStateException("Input stream cannot be null if programm arguments are not provided"))
        }
    }
}