package operationtype;

import static db.Storage.fruitValueMap;

import model.FruitRecord;

public class BalanceHandler implements OperationHandler {

    @Override
    public void apply(FruitRecord fruitRecord) {
        fruitValueMap.put(fruitRecord.getFruit(), fruitRecord.getAmount());
    }
}
