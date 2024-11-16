class Huawei(model: String, year: String, price: Double) : Phone(model, year, price) {
    override var countPhone: Int = 0

    override fun copy(model: String, year: String, price: Double): Huawei {
        return Huawei(model, year, price)
    }
}