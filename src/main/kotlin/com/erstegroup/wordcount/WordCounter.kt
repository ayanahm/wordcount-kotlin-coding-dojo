package com.erstegroup.wordcount

import java.util.regex.Pattern

object WordCounter {
    private val regex = Pattern.compile("[a-zA-Z]+").toRegex()

    fun countWords(text: String) : Int {
        val tokens = splitTextBySpace(text)
        return tokens.count { isAWord(it) }
    }

    private fun isAWord(text: String): Boolean {
        return text.matches(regex)
    }

    private fun splitTextBySpace(text: String): List<String> {
        return text.split(" ")
    }
}