package core.basesyntax.strategy;

public class SupplyStrategy implements Strategy {
    @Override
    public Integer calculateFruitQuantity(Integer before, Integer upload) {
        return before + upload;
    }
}
