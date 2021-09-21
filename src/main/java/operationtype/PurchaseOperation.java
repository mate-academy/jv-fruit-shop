package operationtype;

public class PurchaseOperation implements OperationHandler {

    @Override
    public int changeFruitAmount(int fruitInStorage, int amountFromOperation) {
        if (fruitInStorage < amountFromOperation) {
            throw new RuntimeException("Not enough fruit in storage.");
        }
        return fruitInStorage - amountFromOperation;
    }
}
