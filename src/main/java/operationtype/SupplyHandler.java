package operationtype;

import static db.Storage.fruitValueMap;

import model.FruitRecord;

public class SupplyHandler implements OperationHandler {

    @Override
    public void apply(FruitRecord fruitRecord) {
        Integer fruitInStorage = fruitValueMap.get(fruitRecord.getFruit());
        fruitInStorage += fruitRecord.getAmount();
        fruitValueMap.put(fruitRecord.getFruit(), fruitInStorage);
    }
}
