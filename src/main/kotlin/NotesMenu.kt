import data.Archive
import data.Note
import java.util.Scanner

class NotesMenu(private val archive: Archive): Menu<Note>(archive.notes,
    "Список заметок в архиве ${archive.name}\n0. Создать новую заметку") { //ArrayList<Note>
    private var scanner = Scanner(System.`in`)

    override fun createItem() {
        println("Создание новой заметки")

        val name = checkInput("Введите название заметки: ")
        val note: ArrayList<String> = ArrayList()
        var input = checkInput("Начните вводите текст заметки, если вы хотите завершить ввод, нажмите Enter 2 раза.")
        note.add(input)
        do {
            input = scanner.nextLine()
            note.add(input)
        } while (input != "")

        archive.notes.add(Note(name, note))
    }

    override fun openItem(index: Int) {
        printSeparator()
        println("Заметка ${archive.notes[index].name}")
        println(archive.notes[index].getNote())
        println("Нажмите Enter, чтобы выйти")
        scanner.nextLine()
    }

}
