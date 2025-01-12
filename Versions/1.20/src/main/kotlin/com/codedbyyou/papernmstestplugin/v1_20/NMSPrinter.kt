package com.codedbyyou.papernmstestplugin.v1_20

import com.codedbyyou.papernmstestplugin.shared.NMSPrinterInt
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer

class NMSPrinter : NMSPrinterInt {

    override fun printNMS(player: Any) {
        if (player !is CraftPlayer) return
        println("Printing NMS From 1_20")
        player.sendMessage("The plugin is using 1.20 NMS")
    }

}