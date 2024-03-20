package core.basesyntax.strategy;

public class BalanceStrategy implements Strategy {
    @Override
    public Integer calculateFruitQuantity(Integer before, Integer upload) {
        return upload;
    }
}
