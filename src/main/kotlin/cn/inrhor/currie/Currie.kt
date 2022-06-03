package cn.inrhor.currie

import taboolib.common.platform.Plugin
import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration

/**
 * 入口
 */
object Currie : Plugin() {
    @Config("config.yml", migrate = true, autoReload = true)
    lateinit var config: Configuration
        private set
}

