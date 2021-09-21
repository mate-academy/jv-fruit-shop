package fruitshop.service.operations;

import fruitshop.fruitstoragedb.FruitStorage;
import fruitshop.model.Fruit;
import fruitshop.model.OperationsDto;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void applyOperation(OperationsDto data) {
        Map<Fruit,Integer> fruitStorage = FruitStorage.getStorage();
        Fruit fruit = data.getFruitType();
        int supplyAmount = data.getAmount();
        if (fruitStorage.containsKey(fruit)) {
            Integer amountBeforeSupply = fruitStorage.get(fruit);
            Integer amountAfterSupply = amountBeforeSupply + supplyAmount;
            fruitStorage.replace(fruit, amountBeforeSupply, amountAfterSupply);
        } else {
            fruitStorage.put(fruit, supplyAmount);
        }
    }
}
