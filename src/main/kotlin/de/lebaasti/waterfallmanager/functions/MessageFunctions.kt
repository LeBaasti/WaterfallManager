package de.lebaasti.waterfallmanager.functions

import net.md_5.bungee.api.ChatColor

fun addBlankFields(amount: Int, blank: String = " ") : String {
    var string = ""
    for(i in 0 until amount) {
        string += blank
    }
    return string
}

fun String.center(maxSize: Int = 49): String {
    val string = ChatColor.stripColor(this).take(49)
    val size = (maxSize - string.length) / 2
    return "${addBlankFields(size)}$this"
}