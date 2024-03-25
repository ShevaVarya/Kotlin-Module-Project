package data

import java.lang.StringBuilder

data class Note(override val name: String, private val note: ArrayList<String>): Name {
    fun getNote(): String {
        val string = StringBuilder()
        for (line in note) {
            string.append("$line\n")
        }
        return string.toString()
    }
}