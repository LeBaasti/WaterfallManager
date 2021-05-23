package de.lebaasti.waterfallmanager.commands

import de.lebaasti.waterfallmanager.functions.maintenance
import de.lebaasti.waterfallmanager.functions.sendTextMessage
import de.lebaasti.waterfallmanager.prefix
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.ProxyServer
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.plugin.Command

class MaintenanceCommand(private val proxy: ProxyServer) : Command("maintenance", "waterfallmanager.command.maintenance", "wartungsarbeiten") {

    override fun execute(sender: CommandSender, args: Array<out String>) {
        val ussage = "$prefix §e/maintenance <on/off>"
        if(args.size == 1) {
            when {
                args[0] == "on" -> {
                    if(maintenance) sender.sendTextMessage("$prefix §7Die Wartungsarbeiten sind bereits aktiviert")
                    else {
                        maintenance = true
                        proxy.players.forEach {
                            if(!it.hasPermission("waterfallmanager.maintenance.bypass")) {
                                it.disconnect(TextComponent("§4§lWartungsarbeiten"))
                            }
                        }
                        sender.sendTextMessage("$prefix §7Die Wartungsarbeiten wurden aktiviert")
                    }
                }
                args[0] == "off" -> {
                    if(!maintenance) sender.sendTextMessage("$prefix §7Die Wartungsarbeiten sind bereits deaktiviert")
                    else {
                        maintenance = false
                        sender.sendTextMessage("$prefix §7Die Wartungsarbeiten wurden deaktiviert")
                    }
                }
                else -> sender.sendTextMessage(ussage)
            }
        } else sender.sendTextMessage(ussage)
    }
}