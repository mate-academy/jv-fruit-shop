package core.basesyntax.strategy;

public class PurchaseStrategy implements Strategy {
    @Override
    public Integer calculateFruitQuantity(Integer before, Integer upload) {
        return before - upload;
    }
}
