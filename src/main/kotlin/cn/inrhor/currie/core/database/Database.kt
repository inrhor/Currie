package cn.inrhor.currie.core.database

import cn.inrhor.currie.core.database.type.DatabaseSQL
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*

abstract class Database {

    abstract fun push(uuid: UUID, economy: Double)

    abstract fun delete(uuid: UUID)

    abstract fun exist(uuid: UUID): Boolean

    abstract fun getBalance(uuid: UUID): Double

    abstract fun addBalance(uuid: UUID, economy: Double)

    abstract fun delBalance(uuid: UUID, economy: Double)

    abstract fun setBalance(uuid: UUID, economy: Double)

    companion object {

        lateinit var database: Database

        @Awake(LifeCycle.ACTIVE)
        fun initDatabase() {
            database = DatabaseSQL()
        }

    }

}