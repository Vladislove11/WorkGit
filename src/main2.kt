import java.util.*

fun main (){
    val phone1 = listOf<Phone>(
        Samsung("Galaxy S24", "2024", 74999.0),
        Samsung("Galaxy A35", "2024", 29999.0),
        Samsung("Galaxy A15", "2024", 19999.0)
    )

    val fal = Samsung("Galaxy S24", "2024", 74999.0)
    val fal2 = mutableListOf<Phone>()

    for(item in phone1){
        fal2.add(item.copy(item.model, item.year, item.price))
    }

    for(item in fal2){
        println(item)
    }

//    //����������� ������
//    val phone2 = phone1.cop// mutableListOf<Phone>()
//    phone1.map { it.cop }
//    phone2.addAll(phone1)
//    //���������� ���� ������� � ������������� ������
//    val cityCountSalesPhone = mutableMapOf("1" to phone1, "2" to phone2)
//
//    //������ ������ ���� � �������� ���������
//    val tmpListPhone1 = cityCountSalesPhone["1"]
//
//    //������ ��������� � ���������� ������ ������� � ������������� ������
//    if(tmpListPhone1 != null) {
//        tmpListPhone1[0].countPhone = 1
//        cityCountSalesPhone.replace("1", tmpListPhone1)
//    }
//    // ������ ������ ��� ��������
//    val tmpListPhone2 = cityCountSalesPhone["1"]
//    val tmpListPhone3 = cityCountSalesPhone["2"]
//
//    //��������� �� ��������
//    if(tmpListPhone3 != null && tmpListPhone2 != null) {
//        println(tmpListPhone3[0].countPhone)
//        println(tmpListPhone2[0].countPhone)
//    }


}