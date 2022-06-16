package cn.inrhor.currie.api.treasury.currency

import me.lokka30.treasury.api.economy.currency.Currency
import me.lokka30.treasury.api.economy.response.EconomySubscriber
import java.math.BigDecimal
import java.util.*

class TreasuryCurrency: Currency {
    override fun getIdentifier(): String {
        TODO("Not yet implemented")
    }

    override fun getSymbol(): String {
        TODO("Not yet implemented")
    }

    override fun getDecimal(): Char {
        TODO("Not yet implemented")
    }

    override fun getDisplayNameSingular(): String {
        TODO("Not yet implemented")
    }

    override fun getDisplayNamePlural(): String {
        TODO("Not yet implemented")
    }

    override fun getPrecision(): Int {
        TODO("Not yet implemented")
    }

    override fun isPrimary(): Boolean {
        TODO("Not yet implemented")
    }

    override fun to(currency: Currency, amount: BigDecimal, subscription: EconomySubscriber<BigDecimal>) {
        TODO("Not yet implemented")
    }

    override fun parse(formatted: String, subscription: EconomySubscriber<BigDecimal>) {
        TODO("Not yet implemented")
    }

    override fun getStartingBalance(playerID: UUID?): BigDecimal {
        TODO("Not yet implemented")
    }

    override fun format(amount: BigDecimal, locale: Locale?): String {
        TODO("Not yet implemented")
    }

    override fun format(amount: BigDecimal, locale: Locale?, precision: Int): String {
        TODO("Not yet implemented")
    }
}