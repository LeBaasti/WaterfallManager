package de.lebaasti.waterfallmanager.listeners

import de.lebaasti.waterfallmanager.functions.center
import de.lebaasti.waterfallmanager.functions.maintenance
import net.md_5.bungee.api.ServerPing
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.event.ProxyPingEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler
import java.util.*

class ProxyPingListener : Listener {

    @EventHandler
    fun onProxyPingEvent(event: ProxyPingEvent) {
        val serverPing = event.response
        val line1 = "§b§lEinfach-MC.net §8[§a§l1.16.X§r§8]".center()
        val line2 = "§aBewerbungsphase für §cContent(Building) §aeröffnet".center()
        serverPing.descriptionComponent = TextComponent("$line1\n$line2")
        serverPing.players = ServerPing.Players(
            serverPing.players.max,
            serverPing.players.online,
            arrayOf(
                playerInfo("§a"),
                playerInfo("§bDiscord §8» §7dc.einfach-mc.net"),
                playerInfo("§bTeamspeak §8» §7ts.einfach-mc.net"),
                playerInfo("§bWebsite §8» §7www.einfach-mc.net"),
                playerInfo("§a")
            ))
        //serverPing.version = ServerPing.Protocol("§4§lWARTUNGSARBEITEN", 2)
        event.response = serverPing
    }

    private fun playerInfo(string: String): ServerPing.PlayerInfo {
        return ServerPing.PlayerInfo(string, UUID.randomUUID())
    }

}