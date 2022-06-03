package cn.inrhor.currie.command

import taboolib.common.platform.command.*


@CommandHeader("currie")
internal object Command {

    @CommandBody(permission = "currie.admin.eco")
    val eco = EcoCommand.eco

}