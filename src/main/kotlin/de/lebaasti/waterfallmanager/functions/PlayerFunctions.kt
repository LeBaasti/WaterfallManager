package de.lebaasti.waterfallmanager.functions

import net.luckperms.api.model.group.Group
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.ProxiedPlayer

var ProxiedPlayer.group: Group?
    get() = luckPerms.userManager.getUser(this.uniqueId)?.group
    set(value) {
        val user = luckPerms.userManager.getUser(this.uniqueId)
        if(user != null) {
            user.group = value
        }
    }

fun CommandSender.sendTextMessage(string: String) = sendMessage(TextComponent(string))
