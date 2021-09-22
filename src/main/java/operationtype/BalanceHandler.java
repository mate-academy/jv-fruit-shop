package operationtype;

import static db.Storage.fruitQuantity;

import model.FruitRecord;

public class BalanceHandler implements OperationHandler {

    @Override
    public void apply(FruitRecord fruitRecord) {
        fruitQuantity.put(fruitRecord.getFruit(), fruitRecord.getAmount());
    }
}
