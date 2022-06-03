package cn.inrhor.currie.core.database.type

import cn.inrhor.currie.Currie
import cn.inrhor.currie.core.database.Database
import taboolib.module.database.ColumnOptionSQL
import taboolib.module.database.ColumnTypeSQL
import taboolib.module.database.HostSQL
import taboolib.module.database.Table
import java.util.*
import javax.sql.DataSource

/**
 * MySQL
 */
class DatabaseSQL: Database() {

    val host = HostSQL(Currie.config.getConfigurationSection("data.mysql")!!)

    val table = Currie.config.getString("data.mysql.table")

    /**
     * 用户表
     * id, uuid, name, leave
     */
    val tableUser = Table(table+"_user", host) {
        add { id() }
        add("uuid") {
            type(ColumnTypeSQL.VARCHAR, 36) {
                options(ColumnOptionSQL.UNIQUE_KEY)
            }
        }
        add("name") {
            type(ColumnTypeSQL.VARCHAR, 36) {
                options(ColumnOptionSQL.UNIQUE_KEY)
            }
        }
        add("leave") {
            type(ColumnTypeSQL.DATETIME)
        }
    }

    /**
     * 经济表
     * id, name
     */
    val tableEconomy = Table(table+"_economy", host) {
        add { id() }
        add("name") {
            type(ColumnTypeSQL.DOUBLE)
        }
    }

    /**
     * 用户数据表
     * user, economy, value
     */
    val tableData = Table(table+"_data", host) {
        add("user") {
            type(ColumnTypeSQL.INT, 16) {
                options(ColumnOptionSQL.KEY)
            }
        }
        add("economy") {
            type(ColumnTypeSQL.INT, 16) {
                options(ColumnOptionSQL.KEY)
            }
        }
        add("value") {
            type(ColumnTypeSQL.DOUBLE)
        }
    }

    val source: DataSource by lazy {
        host.createDataSource()
    }

    init {
        tableUser.workspace(source) {
            createTable()
        }.run()
    }

    override fun push(uuid: UUID, economy: Double) {
        if (!exist(uuid)) {
            tableUser.workspace(source) {
                insert("uuid", "name", "economy") {

                }
            }.run()
            return
        }
        tableUser.workspace(source) {
            update {
                where {
                    "uuid" eq uuid.toString()
                }
//                set("economy", eco)
            }
        }.run()
    }

    override fun delete(uuid: UUID) {
        tableUser.workspace(source) {
            delete {
                where {
                    "uuid" eq uuid.toString()
                }
            }
        }.run()
    }

    override fun exist(uuid: UUID): Boolean {
        return tableUser.workspace(source) {
            select {
                where {
                    "uuid" eq uuid.toString()
                }
            }
        }.find()
    }

    override fun getBalance(uuid: UUID): Double {
        tableUser.workspace(source) {
            select {
                where {
                    "uuid" eq uuid.toString()
                    rows("economy")
                }
            }
        }.map {
            getDouble("economy")
        }.forEach {
            return it
        }
        return 0.0
    }

    override fun setBalance(uuid: UUID, economy: Double) {
        push(uuid, economy)
    }

    override fun addBalance(uuid: UUID, economy: Double) {
        push(uuid, getBalance(uuid)+economy)
    }

    override fun delBalance(uuid: UUID, economy: Double) {
        push(uuid, getBalance(uuid)-economy)
    }

}