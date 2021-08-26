package dao

interface Dao<T, UID> {//val dao : Dou<Student> = Studentdao()
    fun getData () : List<T>// mengambil semua data dari database
    fun addData(item : T)// memasukan database
    fun deleteData(uniqueID : UID)

}