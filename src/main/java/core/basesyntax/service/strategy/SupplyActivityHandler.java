package core.basesyntax.service.strategy;

public class SupplyActivityHandler implements ActivityHandler {
    @Override
    public int quantityModify(int quantityBefore, int quantityAfter) {
        return quantityBefore + quantityAfter;
    }
}
