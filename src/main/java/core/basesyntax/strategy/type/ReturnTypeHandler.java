package core.basesyntax.strategy.type;

public class ReturnTypeHandler implements TypeHandlers {

    @Override
    public int operation(int currentQuantity, int newQuantity) {
        return currentQuantity + newQuantity;
    }
}
