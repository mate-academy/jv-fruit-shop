package fruitshop.service.operations;

import fruitshop.fruitstoragedb.FruitStorage;
import fruitshop.model.Fruit;
import fruitshop.model.RecordDto;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void applyOperation(RecordDto data) {
        Fruit fruit = data.getFruitType();
        int amountOfReturnedFruits = data.getAmount();
        if (FruitStorage.getStorage().containsKey(fruit)) {
            Integer amountAfterReturn = FruitStorage.getStorage()
                    .get(fruit) + amountOfReturnedFruits;
            FruitStorage.getStorage().replace(fruit, FruitStorage.getStorage()
                    .get(fruit), amountAfterReturn);
        } else {
            FruitStorage.getStorage().put(fruit, amountOfReturnedFruits);
        }
    }
}
