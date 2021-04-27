package core.basesyntax.service.strategy;

public class BalanceTypeHandler implements TypeHandler {
    @Override
    public int getTypeHandler(int amount) {
        return amount;
    }
}
