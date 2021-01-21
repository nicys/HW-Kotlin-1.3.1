fun main(args: Array<String>) {
    val timeSec = 7201

    val agoToText = writeTimeAgo(timeSec)
    println("был(а) в сети $agoToText")
}

fun writeMinutes(times: Int): String {
    val timeMinute = times / 60
    return when(timeMinute % 10) {
        1 -> "$timeMinute минуту назад"
        in 2..4 -> "$timeMinute минуты назад"
        else -> "$timeMinute минут назад"
    }
}

fun writeHours(times: Int): String {
    val timeHours = times / 3_600
    return when(timeHours % 10) {
        1 -> "$timeHours час назад"
        in 2..4 -> "$timeHours часа назад"
        else -> "$timeHours часов назад"
    }
}

fun writeTimeAgo(timeSec: Int): String {
    return when(timeSec) {
        in 0..60 -> "только что"
        in 61..3_600 -> writeMinutes(timeSec)
        in 3_601..86_400 -> writeHours(timeSec)
        in 86_401..172_800 -> "сегодня"
        in 172_801..259_200 -> "вчера"
        else -> "давно"
    }
}