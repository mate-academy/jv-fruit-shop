package core.basesyntax.service.operations;

public class BalanceOperation implements FruitOperation {

    @Override
    public void operation(String[] data) {
        createKeyValue(data);
    }
}
