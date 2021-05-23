package de.lebaasti.waterfallmanager.functions

import de.lebaasti.waterfallmanager.instance
import net.md_5.bungee.config.Configuration
import net.md_5.bungee.config.ConfigurationProvider
import net.md_5.bungee.config.YamlConfiguration
import java.io.File

val file = File(instance.dataFolder, "config.yml")
val provider: ConfigurationProvider = ConfigurationProvider.getProvider(YamlConfiguration::class.java)
var config: Configuration = provider.load(file)

var maintenance: Boolean
    get() = config.getBoolean("maintenance")
    set(value) {
        config.set("maintenance", value)
        provider.save(config, file)

    }