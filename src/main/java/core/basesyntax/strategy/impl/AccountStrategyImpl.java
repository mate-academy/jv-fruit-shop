package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.AccountHandler;
import core.basesyntax.strategy.AccountStrategy;
import core.basesyntax.strategy.AccountType;
import java.util.Map;

public class AccountStrategyImpl implements AccountStrategy {
    private Map<AccountType, AccountHandler> accountHandlerMap;

    public AccountStrategyImpl(Map<AccountType, AccountHandler> accountHandlerMap) {
        this.accountHandlerMap = accountHandlerMap;
    }

    @Override
    public AccountHandler get(AccountType type) {
        return accountHandlerMap.get(type);
    }
}
