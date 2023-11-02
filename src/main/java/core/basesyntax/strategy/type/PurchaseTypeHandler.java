package core.basesyntax.strategy.type;

public class PurchaseTypeHandler implements TypeHandlers {

    @Override
    public int operation(int currentQuantity, int newQuantity) {
        return currentQuantity - newQuantity;
    }
}
