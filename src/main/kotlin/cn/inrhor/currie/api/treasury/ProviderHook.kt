package cn.inrhor.currie.api.treasury

import me.lokka30.treasury.api.economy.EconomyProvider
import me.lokka30.treasury.api.economy.account.Account
import me.lokka30.treasury.api.economy.account.PlayerAccount
import me.lokka30.treasury.api.economy.currency.Currency
import me.lokka30.treasury.api.economy.misc.OptionalEconomyApiFeature
import me.lokka30.treasury.api.economy.response.EconomySubscriber
import java.util.*

/**
 * 经济提供与管理
 */
class Provider: EconomyProvider {

    override fun getSupportedOptionalEconomyApiFeatures(): MutableSet<OptionalEconomyApiFeature> {
        TODO("Not yet implemented")
    }

    override fun hasPlayerAccount(accountId: UUID, subscription: EconomySubscriber<Boolean>) {
        TODO("Not yet implemented")
    }

    override fun retrievePlayerAccount(accountId: UUID, subscription: EconomySubscriber<PlayerAccount>) {
        TODO("Not yet implemented")
    }

    override fun createPlayerAccount(accountId: UUID, subscription: EconomySubscriber<PlayerAccount>) {
        TODO("Not yet implemented")
    }

    override fun retrievePlayerAccountIds(subscription: EconomySubscriber<MutableCollection<UUID>>) {
        TODO("Not yet implemented")
    }

    override fun hasAccount(identifier: String, subscription: EconomySubscriber<Boolean>) {
        TODO("Not yet implemented")
    }

    override fun retrieveAccount(identifier: String, subscription: EconomySubscriber<Account>) {
        TODO("Not yet implemented")
    }

    override fun createAccount(name: String?, identifier: String, subscription: EconomySubscriber<Account>) {
        TODO("Not yet implemented")
    }

    override fun retrieveAccountIds(subscription: EconomySubscriber<MutableCollection<String>>) {
        TODO("Not yet implemented")
    }

    override fun retrieveNonPlayerAccountIds(subscription: EconomySubscriber<MutableCollection<String>>) {
        TODO("Not yet implemented")
    }

    override fun getPrimaryCurrency(): Currency {
        TODO("Not yet implemented")
    }

    override fun findCurrency(identifier: String): Optional<Currency> {
        TODO("Not yet implemented")
    }

    override fun getCurrencies(): MutableSet<Currency> {
        TODO("Not yet implemented")
    }

    override fun registerCurrency(currency: Currency, subscription: EconomySubscriber<Boolean>) {
        TODO("Not yet implemented")
    }


}