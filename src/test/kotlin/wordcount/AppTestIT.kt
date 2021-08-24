package wordcount

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class AppTestIT {

    private val inputTextBin = "Mary had a little lamb".byteInputStream()
    private val inputTextTestFile = "testdata/input1.txt"

    @Test
    fun `WordCounterApp reads user input and writes the word count`(){
        val outputBuffer = ByteArrayOutputStream()
        val app = App(
            inStream = inputTextBin,
            outStream = outputBuffer
        )

        app.run(arrayOf())

        val actualOutput = outputBuffer.toString()
        Assertions.assertEquals("4", actualOutput)
    }

    @Test
    fun `WordCounterApp reads user input from provided file and writes the word count`(){
        val outputBuffer = ByteArrayOutputStream()
        val app = App(
            inStream = null,
            outStream = outputBuffer
        )

        app.run(arrayOf(inputTextTestFile))

        val actualOutput = outputBuffer.toString()
        Assertions.assertEquals("4", actualOutput)
    }

}