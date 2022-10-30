package core.basesyntax.strategy;

public interface AddToBalanceStrategy extends ExistFruit {
    void action(String fruit, Integer quantity);
}
