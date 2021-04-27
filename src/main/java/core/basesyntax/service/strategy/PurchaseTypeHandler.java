package core.basesyntax.service.strategy;

public class PurchaseTypeHandler implements TypeHandler {
    @Override
    public int getTypeHandler(int amount) {
        return -amount;
    }
}
