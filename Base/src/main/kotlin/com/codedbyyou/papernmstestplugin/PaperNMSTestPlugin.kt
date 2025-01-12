package com.codedbyyou.papernmstestplugin

import com.codedbyyou.papernmstestplugin.versions.VersionHandler
import org.bukkit.plugin.java.JavaPlugin

class PaperNMSTestPlugin : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        logger.info("Hello, PaperNMSTestPlugin!")

        // Initialize the VersionHandler
        VersionHandler

        // command to test NMS
        getCommand("testnms")?.setExecutor { sender, _, _, _ ->
            VersionHandler.printer.printNMS(sender)
            true
        }

    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("Goodbye, PaperNMSTestPlugin!")
    }
}
