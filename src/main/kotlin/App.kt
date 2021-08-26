import dao.Dao
import dao.StudentDao
import model.Student
import kotlin.system.exitProcess

class App {
    private val dao: Dao<Student, String> = StudentDao()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().start()

        }
    }

        fun start() {
            navigateToMainMenu()

        }

    private fun printHeader() {
        println(
            """
         ======================================
                Aplikasi data Mahasiswa
         ======================================
         1. Cetak Semua Data Mahasiswa
         2. Tambah Data mahasiswa
         3. Hapus Data Mahasiswa
         4. Keluar
         ======================================
         Enter menu ? (1/2/3/4)
         ======================================    
        """.trimIndent()
        )


    }

    private fun navigateToMainMenu(menu: String) {
        when (menu) {
            "1" -> {
                openMenuPrintStudent()
            }
            "2" -> {

                openMenuInsertStudent()

            }
            "3" -> {
                openMenuDeletStudent()

            }
            "4" -> {
                exitProcess(0)

            }
            else -> {
                println("No menu matches")
            }
        }
        askToMainMenu()

    }

    private fun openMenuDeletStudent() {

        println("======================================")
        println("Hapus Data Dengan NIM = ")
        readLine()?.let {
            dao.deleteData(it)
        }
        println("======================================")
        println("Data Berhasil dihapus")

    }

    private fun openMenuInsertStudent() {

        println("======================================")
        println("Nama Mahasiswa = ")
        val name = readLine().orEmpty()
        println("NIM Mahasiswa = ")
        val nim = readLine().orEmpty()
        println("Jurusan Mahasiswa = ")
        val major = readLine().orEmpty()
        println("Kelas = ")
        val className = readLine().orEmpty()
        println("Nama Universitas = ")
        val univ = readLine().orEmpty()
        dao.addData(Student(name, nim, major, className, univ))
        println("===============================================")
        println("Insert Data Berhasil")
    }

    private fun openMenuPrintStudent() {

        val students = dao.getData()
        if (students.isNotEmpty()) {
            students.forEachIndexed { index, student ->
                println("===============================================")
                println("Mahasiswa ke-${index + 1}")
                println("===============================================")
                println("Nama       : ${student.name}")
                println("NIM        : ${student.nim}")
                println("Jurusan    : ${student.major}")
                println("Kelas      : ${student.className}")
                println("University : ${student.university}")
            }
        } else {
            println("======================================")
            println("Tidak Ada Data !")
            println("======================================")
        }
    }

    private fun askToMainMenu() {

        println(
            """
            Kembali ke menu Utama ? (Y/N)
        """.trimIndent()
        )
        if (readLine().equals("y", ignoreCase = true)) {
            navigateToMainMenu()
        }   else {
            exitProcess(0)
        }

    }

    private fun navigateToMainMenu() {
        printHeader()
        readLine()?.let {
            navigateToMainMenu(it)
        }

    }
}