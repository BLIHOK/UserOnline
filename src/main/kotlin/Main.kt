fun main(args: Array<String>) {
    println(agoToText(59)) // 59 секунд
    println(agoToText(60)) // 1 минута
    println(agoToText(180)) // 3 минуты
    println(agoToText(600)) // 10 минут
    println(agoToText(1260)) // 21 минута
    println(agoToText(1320)) // 22 минуты
    println(agoToText(3600)) // 1 час
    println(agoToText(7200)) // 2 часа
    println(agoToText(18000)) // 5 часов
    println(agoToText(72000)) // 20 часов
}

fun agoToText(time: Int): String {
    val minute = 60
    val hour = 3600
    val day = 86400

    val minutes = time % 3600 / 60
    val hours = time % 86400 / 3600

    val checkTime = when (time) {
        in 2 * day until 3 * day -> "Позавчера"
        in day until 2 * day -> "Вчера"
        in hour until day -> "$hours час${getHourEnding(hours)} назад"
        in minute until hour -> "$minutes минут${getMinuteEnding(minutes)} назад"
        in 0 until minute -> "только что"
        else -> "Давно"
    }
    return checkTime
}

fun getMinuteEnding(minutes: Int): String {
    return when (minutes) {
        in 2..4,
        in 22..24,
        in 32..34,
        in 42..44,
        in 52..54 -> "ы"
        1, 21, 31, 41, 51 -> "у"
        else -> ""
    }
}

fun getHourEnding(hours: Int): String {
    return when (hours) {
        in 5..20 -> "ов"
        2, 3, 4, 22, 23 -> "а"
        else -> ""
    }
}
