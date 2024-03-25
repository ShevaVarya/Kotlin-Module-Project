import data.Archive

fun main() {
    val archives: ArrayList<Archive> = arrayListOf()
    val menu = ArchiveMenu(archives)
    menu.start()
}