package cn.inrhor.currie.server

import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

/**
 * 运行处理
 */
object PluginLoader {

    @Awake(LifeCycle.ENABLE)
    fun onEnable() {
        Logger.loadInfo()
    }

}