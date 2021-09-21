package operationtype;

public class ReturnOperation implements OperationHandler {
    @Override
    public int changeFruitAmount(int fruitInStorage, int amountFromOperation) {
        return fruitInStorage + amountFromOperation;
    }
}
