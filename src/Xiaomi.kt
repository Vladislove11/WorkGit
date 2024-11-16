class Xiaomi(model: String, year: String, price: Double) : Phone(model, year, price) {
    override var countPhone: Int = 0

    override fun copy(model: String, year: String, price: Double): Xiaomi {
        return Xiaomi(model, year, price)
    }

}