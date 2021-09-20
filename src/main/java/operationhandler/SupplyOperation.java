package operationhandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public int changeFruitAmount(int fruitInStorage, int amountFromOperation) {
        return fruitInStorage + amountFromOperation;
    }
}
