package core.basesyntax.strategy;

public interface PurchaseStrategy extends ExistFruit {
    void action(String fruit, Integer quantity);
}
