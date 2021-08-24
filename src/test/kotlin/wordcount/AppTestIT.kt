package wordcount

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class AppTestIT {

    private val inputTextBin = "Mary had a little lamb".byteInputStream()
    private val inputTextTestFile1 = "testdata/input1.txt"
    private val inputTextTestFile2 = "testdata/input2.txt"

    @Test
    fun `WordCounterApp reads user input and writes the word count`(){
        val outputBuffer = ByteArrayOutputStream()
        val app = App(
            inStream = inputTextBin,
            outStream = outputBuffer
        )

        app.run(arrayOf())

        val actualOutput = outputBuffer.toString()
        Assertions.assertEquals("Number of words: 4, unique: 4", actualOutput)
    }

    @Test
    fun `WordCounterApp reads user input from provided file1 and writes the word count`(){
        val outputBuffer = ByteArrayOutputStream()
        val app = App(
            inStream = null,
            outStream = outputBuffer
        )

        app.run(arrayOf(inputTextTestFile1))

        val actualOutput = outputBuffer.toString()
        Assertions.assertEquals("Number of words: 4, unique: 4", actualOutput)
    }

    @Test
    fun `WordCounterApp reads user input from provided file2 and writes the word count`(){
        val outputBuffer = ByteArrayOutputStream()
        val app = App(
            inStream = null,
            outStream = outputBuffer
        )

        app.run(arrayOf(inputTextTestFile2))

        val actualOutput = outputBuffer.toString()
        Assertions.assertEquals("Number of words: 9, unique: 7", actualOutput)
    }

}