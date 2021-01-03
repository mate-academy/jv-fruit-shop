package core.basesyntax;

public class BalanceOperation implements Operation {
    @Override
    public void execute(String fruit, Integer amount) {
        Warehouse.getStorage().put(fruit, amount);
    }
}
