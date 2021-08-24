package wordcount

import java.io.InputStream

class InputStreamSingleLineTextProvider(private val inStream: InputStream) : InputTextProvider {
    override fun getText(): String {
        return inStream
            .bufferedReader()
            .use { br -> br.readLine() }
    }
}