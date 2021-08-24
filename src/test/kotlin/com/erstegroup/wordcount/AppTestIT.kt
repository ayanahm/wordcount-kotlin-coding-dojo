package com.erstegroup.wordcount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream

class AppTestIT {

    @Test
    fun `WordCounterApp reads input and writes the word count`(){
        val outputBuffer = ByteArrayOutputStream()
        val app = App(
            inStream = "Mary had a little lamb".byteInputStream(),
            outStream = outputBuffer
        )

        app.run()

        val actualOutput = outputBuffer.toString()
        assertEquals("5", actualOutput)
    }
}