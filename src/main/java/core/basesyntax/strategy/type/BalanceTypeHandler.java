package core.basesyntax.strategy.type;

public class BalanceTypeHandler implements TypeHandlers {

    @Override
    public int operation(int currentQuantity, int newQuantity) {
        return newQuantity;
    }
}
