package com.codedbyyou.papernmstestplugin.versions.v1_21

import com.codedbyyou.papernmstestplugin.shared.NMSPrinterInt
import org.bukkit.craftbukkit.entity.CraftPlayer


class NMSPrinter : NMSPrinterInt {

    override fun printNMS(player: Any) {
        if (player !is CraftPlayer) return
        println("Printing NMS From 1_21")
        player.sendMessage("The plugin is using 1.21 NMS")
    }

}