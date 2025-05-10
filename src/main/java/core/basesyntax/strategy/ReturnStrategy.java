package core.basesyntax.strategy;

public class ReturnStrategy implements Strategy {
    @Override
    public Integer calculateFruitQuantity(Integer before, Integer upload) {
        return before + upload;
    }
}
