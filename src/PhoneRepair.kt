data class PhoneRepair(val city: String) {
    var countRepair = 0

    fun phoneRepair(){
        println("Ваш телефон отремонтирован")
        println("Спасибо, что воспользовались нашим сервисом!")
    }
}