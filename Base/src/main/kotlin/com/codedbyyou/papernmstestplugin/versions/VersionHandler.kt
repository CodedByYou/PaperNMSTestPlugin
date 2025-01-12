package com.codedbyyou.papernmstestplugin.versions

import com.codedbyyou.papernmstestplugin.versions.v1_21.NMSPrinter
import com.codedbyyou.papernmstestplugin.shared.NMSPrinterInt
import org.bukkit.Bukkit

object VersionHandler {

    val printer : NMSPrinterInt
    val versions = listOf("v1_20", "v1_21")

    private val defaultVersion = "v1_21"


    init {

        val currentVersion = Bukkit.getServer().javaClass.`package`.name.split(".").getOrNull(3)?.let {
            normalizeVersion(it)
        } ?: defaultVersion

        if (!versions.contains(currentVersion)) {
            Bukkit.getLogger().severe("Unsupported version: $currentVersion")
            Bukkit.getPluginManager().getPlugin("PaperNMSTestPlugin")
                ?.let { Bukkit.getPluginManager().disablePlugin(it) }
            throw Exception("Unsupported version: $currentVersion")
        }

        printer = if (currentVersion == "v1_20") {
            com.codedbyyou.papernmstestplugin.v1_20.NMSPrinter()
        } else {
            NMSPrinter()
        }
        Bukkit.getLogger().info("Version Handler Initialized")
    }

    // Normalize version strings, e.g., "v1_20_R1" -> "v1_20", "v1_20_1" -> "v1_20"
    private fun normalizeVersion(version: String): String {
        return version.split("_").take(2).joinToString("_") // Keep only "1_xx"
    }
}