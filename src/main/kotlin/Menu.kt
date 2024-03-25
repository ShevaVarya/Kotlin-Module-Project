import data.Name
import java.util.InputMismatchException
import java.util.Scanner

abstract class Menu<T: Name> (private val arrayList: ArrayList<T>, private val headlineMenu: String){
    private val scanner = Scanner(System.`in`)

    open fun start() {
        while (true) {
            printSeparator()
            printMenu()

            when (val input = askUser()) {
                0 -> {
                    printSeparator()
                    createItem()
                }

                in 1..arrayList.size -> {
                    openItem(input - 1)
                }

                (arrayList.size + 1) -> {
                    return
                }
            }
        }
    }

    private fun printMenu() {
        println(headlineMenu)
        for (i in 0 until arrayList.size) {
            println("${i + 1}. ${arrayList[i].name}")
        }
        println("${arrayList.size + 1}. Выход")
    }

    private fun askUser(): Int {
        println("Что вы хотите сделать? Введите число: ")
        var input: Int = -1
        while (input == -1) {
            try {
                input = scanner.nextInt()
                scanner.nextLine()
                if (input > (arrayList.size + 1)) {
                    println("Хм... Возможно вы ввели слишком большое число. Попробуйте ещё раз!")
                    input = -1
                }
            } catch (_: InputMismatchException) {
                println("Хм... Возможно вы ввели не число. Попробуйте ещё раз!")
                scanner.nextLine()
            }
        }
        return input
    }

    protected fun printSeparator() {
        println("\n============================================\n")
    }

    protected fun checkInput (headline: String): String {
        var input: String
        while (true) {
            println(headline)
            input = scanner.nextLine()
            if (input == "") {
                println("Хм... Возможно вы ничего не ввели. Попробуйте ещё раз!")
                continue
            }
            break
        }
        return input
    }

    abstract fun createItem()
    abstract fun openItem(index: Int)
}