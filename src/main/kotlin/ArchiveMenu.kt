import data.Archive

class ArchiveMenu(private val archives: ArrayList<Archive>): Menu<Archive>(archives, "Список архивов:\n0. Создать новый архив"){

    override fun createItem() {
        println("Создание нового архива")
        val input: String = checkInput("Введите название архива: ")
        archives.add(Archive(input, arrayListOf()))
    }

    override fun openItem(index: Int) {
        val menu = NotesMenu(archives[index])
        menu.start()
    }
}
