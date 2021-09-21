package operationtype;

public class BalanceOperation implements OperationHandler {

    @Override
    public int changeFruitAmount(int fruitInStorage, int amountFromOperation) {
        return amountFromOperation;
    }
}
