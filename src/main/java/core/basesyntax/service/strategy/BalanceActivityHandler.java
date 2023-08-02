package core.basesyntax.service.strategy;

public class BalanceActivityHandler implements ActivityHandler {
    @Override
    public int quantityModify(int quantityBefore, int quantityAfter) {
        return quantityBefore + quantityAfter;
    }
}
