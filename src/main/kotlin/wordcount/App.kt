package wordcount

import java.io.InputStream
import java.io.OutputStream

class App(
    private val inStream: InputStream,
    private val outStream: OutputStream
) {
    fun run() {
        val inputText = inStream
            .bufferedReader()
            .use { br -> br.readLine() }

        val count = WordCounter.countWords(inputText, StopwordsReader.getStopWords())

        outStream
            .bufferedWriter()
            .use { bw -> bw.write(count.toString()) }
    }

}