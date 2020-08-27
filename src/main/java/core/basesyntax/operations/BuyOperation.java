package core.basesyntax.operations;

import core.basesyntax.FruitStore;
import core.basesyntax.model.FruitDto;
import java.time.LocalDate;

public class BuyOperation implements Operation {
    @Override
    public void apply(FruitDto fruitDto) {
        String fruit = fruitDto.getFruit();
        int quantity = fruitDto.getQuantity();
        LocalDate expirationDate = fruitDto.getExpirationDate();
        if (FruitStore.fruitStorage.get(fruit) < quantity
                || !FruitStore.fruitStorage.containsKey(fruit)) {
            throw new RuntimeException("Fruits are not enough");
        }
        if (FruitStore.expirationDateStorage.get(fruit).isBefore(expirationDate)) {
            throw new RuntimeException("Fruits are already expired");
        }
        FruitStore.fruitStorage.put(fruit, FruitStore.fruitStorage.get(fruit) - quantity);
    }
}
