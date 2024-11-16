class Samsung(model: String, year: String, price: Double) : Phone(model, year, price){
    override var countPhone: Int = 0

    override fun getPriceCity(coefficient: Double): Double {
        return price * coefficient
    }

    override fun copy(model: String, year: String, price: Double): Samsung{
        return Samsung(model, year, price)
    }

    override fun toString(): String {
        return "$model - $price"
    }

}

