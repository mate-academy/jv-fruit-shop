package fruitshop.service.operations;

import fruitshop.fruitstoragedb.FruitStorage;
import fruitshop.model.Fruit;
import fruitshop.model.RecordDto;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void applyOperation(RecordDto data) {
        Fruit fruit = data.getFruitType();
        int supplyAmount = data.getAmount();
        if (FruitStorage.getStorage().containsKey(fruit)) {
            Integer amountBeforeSupply = FruitStorage.getStorage().get(fruit);
            Integer amountAfterSupply = amountBeforeSupply + supplyAmount;
            FruitStorage.getStorage().replace(fruit, amountBeforeSupply, amountAfterSupply);
        } else {
            FruitStorage.getStorage().put(fruit, supplyAmount);
        }
    }
}
