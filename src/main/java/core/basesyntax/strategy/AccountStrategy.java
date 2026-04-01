package core.basesyntax.strategy;

public interface AccountStrategy {
    AccountHandler get(AccountType type);
}
