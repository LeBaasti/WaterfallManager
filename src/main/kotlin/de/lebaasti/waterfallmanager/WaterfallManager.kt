package de.lebaasti.waterfallmanager

import de.lebaasti.waterfallmanager.commands.MaintenanceCommand
import de.lebaasti.waterfallmanager.functions.config
import de.lebaasti.waterfallmanager.listeners.PostLoginListener
import de.lebaasti.waterfallmanager.listeners.ProxyPingListener
import net.md_5.bungee.api.plugin.Plugin

class WaterfallManager : Plugin() {

    init {
        instance = this
    }

    override fun onEnable() {
        registerCommands()
        registerListeners()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    private fun registerCommands() {
        proxy.pluginManager.registerCommand(this, MaintenanceCommand(proxy))
    }

    private fun registerListeners() {
        proxy.pluginManager.registerListener(this, ProxyPingListener())
        proxy.pluginManager.registerListener(this, PostLoginListener())
    }

    companion object {
        lateinit var instance: WaterfallManager
    }
}