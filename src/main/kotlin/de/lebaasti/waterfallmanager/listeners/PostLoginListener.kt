package de.lebaasti.waterfallmanager.listeners

import de.lebaasti.waterfallmanager.functions.maintenance
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.event.PostLoginEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler

class PostLoginListener : Listener {

    @EventHandler
    fun onPostLoginEvent(event: PostLoginEvent) {
        val player = event.player
        if (maintenance) {
            if (!player.hasPermission("waterfallmanager.maintenance.bypass")) {
                player.disconnect(TextComponent("§4§lWartungsarbeiten"))
                return
            }
        }
        player.setTabHeader(TextComponent("§a\n§b§lEinfach-MC.net\n§a"), TextComponent("§a\n§a"))
    }

}