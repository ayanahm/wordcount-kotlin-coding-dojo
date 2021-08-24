package wordcount

object StopwordsReader {
    private const val resourcePathLocation = "/stopwords.txt"
    private val newLineDelimeter = System.lineSeparator()

    fun getStopWords(): List<String> {
        val resource = getResourceFromClassPath() ?: throw IllegalStateException("cannot find stopwords at classpath location '$resourcePathLocation'")
        val text = resource.readText()
        return text.split(newLineDelimeter)
    }

    private fun getResourceFromClassPath() = StopwordsReader::class.java.getResource(resourcePathLocation)
}