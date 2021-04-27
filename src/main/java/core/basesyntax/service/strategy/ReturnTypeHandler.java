package core.basesyntax.service.strategy;

public class ReturnTypeHandler implements TypeHandler {
    @Override
    public int getTypeHandler(int amount) {
        return amount;
    }
}
