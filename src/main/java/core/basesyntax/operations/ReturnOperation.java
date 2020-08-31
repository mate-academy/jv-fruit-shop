package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitDto;
import core.basesyntax.model.FruitStorage;

import java.util.Map;

public class ReturnOperation implements Operation {
    private Map<String, Fruit> storage = FruitStorage.getFruitStorage();

    @Override
    public void doOperation(FruitDto fruitDto) {
        String fruitName = fruitDto.getFruitName();
        Integer amountToReturn = fruitDto.getAmount();
        Fruit fruit;
        if (storage.containsKey(fruitName)) {
            fruit = new SupplyOperation().getFruit(fruitDto, fruitName, amountToReturn);
            if (fruit == null) {
                return;
            }
        } else {
            throw new RuntimeException("You can not return this fruit");
        }
    }
}
