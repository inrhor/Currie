package cn.inrhor.currie.command

import cn.inrhor.currie.api.EconomyCore
import cn.inrhor.currie.core.database.Database
import org.bukkit.Bukkit
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.*

internal object EcoCommand {

    val eco = subCommand {
        literal("add") {
            handle(this, Type.ADD)
        }
        literal("del") {
            handle(this, Type.DEL)
        }
        literal("set") {
            handle(this, Type.SET)
        }
        literal("remove") {
            handle(this, Type.REMOVE)
        }
    }

    private fun handle(command: CommandBuilder.CommandComponentLiteral, type: Type) {
        command.dynamic {
            if (type == Type.REMOVE) {
                execute<ProxyCommandSender> { _, context, argument ->
                    val args = argument.split(" ")
                    val player = Bukkit.getOfflinePlayer(args[0])
                    Database.database.delete(player.uniqueId)
                }
            }else {
                dynamic {
                    execute<ProxyCommandSender> { _, context, argument ->
                        val args = argument.split(" ")

                        val player = Bukkit.getOfflinePlayer(context.argument(-1)!!)

                        val economy = args[0].toDouble()

                        when (type) {
                            Type.ADD -> EconomyCore().depositPlayer(player, economy)
                            Type.DEL -> EconomyCore().withdrawPlayer(player, economy)
                            else -> Database.database.setBalance(player.uniqueId, economy)
                        }
                    }
                }
            }
        }
    }

    enum class Type {
        ADD, DEL, REMOVE, SET
    }

}