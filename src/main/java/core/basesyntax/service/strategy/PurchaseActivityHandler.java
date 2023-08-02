package core.basesyntax.service.strategy;

public class PurchaseActivityHandler implements ActivityHandler {
    @Override
    public int quantityModify(int quantityBefore, int quantityAfter) {
        if (quantityAfter > quantityBefore) {
            throw new RuntimeException("you don't have enough fruit purchase.");
        }
        return quantityBefore - quantityAfter;
    }
}
