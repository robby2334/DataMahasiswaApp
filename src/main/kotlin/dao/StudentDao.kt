package dao

import model.Student

class StudentDao : Dao<Student, String> {
    private var students = arrayListOf<Student>().apply {
        add(Student("Tony a Stark", "12345", "Teknik inormatika", "4101A", "Universitas Bhayangkara"))
        add(Student("Tony b Stark", "12346", "Ekonomi", "4101B", "Universitas Indonesia"))
        add(Student("Tony c Stark", "12347", "Sastra Inggris", "4101C", "BSI"))
        add(Student("Tony d Stark", "12348", "Hukum", "4101D", "Universitas Gajah Mada"))
        add(Student("Tony e Stark", "12349", "Teknik ilmu komputer", "4101E", "Universitas Guda Darma"))
    }

    override fun getData(): List<Student> {
        return students
    }

    override fun addData(item: Student) {
        students.add(item)
    }

    override fun deleteData(uniqueID: String) {
        /*      for (student in students){
                  if (student.nim == uniqueID){
                      students.remove(student)*/
        students.remove(students.find { student ->
            student.nim == uniqueID
        })
    }
}
