abstract class Phone (val model: String, val year: String, val price: Double) : City {
    abstract var countPhone: Int

    abstract fun copy(model: String, year: String, price: Double): Phone

    override fun getPriceCity(coefficient: Double): Double {
        return price * coefficient
    }

}