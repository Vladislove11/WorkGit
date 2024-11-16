import java.math.BigDecimal

fun main() {
    val cityCoefficient = mapOf("1" to 0.9, "2" to 1.1)
    val phone1 = listOf<Phone>(
        Samsung("Galaxy S24", "2024", 74999.0),
        Samsung("Galaxy A35", "2024", 29999.0),
        Samsung("Galaxy A15", "2024", 19999.0),
        Huawei("nova Y61", "2024", 10999.0),
        Huawei("nova Y72", "2024", 12999.0),
        Huawei("nova 10SE", "2024", 19999.0),
        Xiaomi("Redmi Note13", "2024", 20999.0),
        Xiaomi("Redmi A3", "2024", 8999.0),
        Xiaomi("13T", "2024", 37999.0)
    )

    val phone2 = mutableListOf<Phone>()
    for(item in phone1){
        phone2.add(item.copy(item.model, item.year, item.price))
    }

    val cityCountSalesPhone = mutableMapOf("1" to phone1, "2" to phone2)
    val phoneRepair1 = PhoneRepair("city")
    val phoneRepair2 = PhoneRepair("city").copy()
    val cityCountPhoneRepair = mutableMapOf("1" to phoneRepair1, "2" to phoneRepair2)

    while (true) {
        println("///////////////////////////////////////////")
        println("�����������, ��� �������� ������� ���������.")
        println("///////////////////////////////////////////")
        println("�������� ���������� �����, ������� ��� ������ ��������:")
        println("1:�������� 2:����������")
        var city = readLine().toString()
        if (city != "1" && city != "2") {
            city = "1"
        }

        println("�������� �����!")
        println("������ ���������� �������:")
        println("1: ��")
        println("2: ���")
        if (readLine().toString() != "1") {
            println("�� ����� ������. ������� � ��� ���!")
            break
        }

        var modelPhone = ""
        cityCountSalesPhone[city]?.let { showAllSoldPhones(it, cityCoefficient.getValue(city)) }
        val phoneRepair = cityCountPhoneRepair[city]

        if (phoneRepair?.countRepair == 0){
            phoneRepair.countRepair = 1
            println("���� ��� ������� �� ��������, �� ������ ��������������� ����� �������� �� ������� ���������:")
            println("1: ��, ��������� � �������.")
            println("2: ���, ������� ��������.")

            if(readLine().toString() != "1"){
                println("�� ��������� � �������")
            } else {
                phoneRepair.phoneRepair()
            }
            println()
                cityCountPhoneRepair[city]?.let { phoneRepair }
        }

        while (true) {
            println("��������� ������� (�������� ������ ��������):")
            for (item in phone1) {
                println("${item::class.simpleName} ${item.model}  " +
                        "${item.getPriceCity(cityCoefficient.getValue(city)).toBigDecimal().setScale(2, BigDecimal.ROUND_HALF_UP)}")
            }

            modelPhone = readLine().toString()
            if (!checkModelPhone(modelPhone, phone1)) {
                println("����� ������ ��� � ����� ��������. �������� ��� �� ������!")
                println("1: ������� ��� ���")
                println("2: ��������� ��������")
            } else {
                break
            }
            val answer = readLine().toString()
            if(answer != "1"){
                break
            }
        }

        println("������ �������� ${phone1.filter { it.model.uppercase() == modelPhone.uppercase() }
                                                     .map { "${it::class.simpleName} ${it.model}; ${it.price}" }}"
        )

        println("1: ���������")
        println("2: �����")

        val answer = readLine().toString()

        if (answer == "1"){
            val tmpListPhone = cityCountSalesPhone[city]
            tmpListPhone?.filter { it.model.uppercase() == modelPhone.uppercase() }
                ?.map { println ("��� ������ �������: ${it::class.simpleName} ${it.model}: ${it.price}")
                       it.countPhone += 1
                }
            if (tmpListPhone != null) {
                cityCountSalesPhone.replace(city,tmpListPhone)
            }
            println()
            println()
        }
    }

}

fun checkModelPhone(name: String, phones: List<Phone>): Boolean{
    var result = false
    for (item in phones){
        if (item.model.uppercase() == name.uppercase()){
            result = true
            break
        }
    }

    return result
}

fun showAllSoldPhones(phones: List<Phone>, coefficient: Double){
    var checkSales = false
    var sum = 0.0
    println("���������� ������� ���������:")
    for(item in phones){
        if(item.countPhone > 0){
            checkSales = true
            sum += coefficient * item.price
            println("   ${item.model} - ${item.countPhone} ")
        }
    }
    if(checkSales) {
        println("����� ������� ��������� �� �����: ${sum.toBigDecimal().setScale(2, BigDecimal.ROUND_HALF_UP)}")
    } else {
        println ("  ���� �� ������� �� ������ ��������")
    }

    println()

}