package core.basesyntax.operations;

import core.basesyntax.FruitStore;
import core.basesyntax.model.FruitDto;
import java.time.LocalDate;

public class ReturnOperation implements Operation {
    @Override
    public void apply(FruitDto fruitDto) {
        String fruit = fruitDto.getFruit();
        int quantity = fruitDto.getQuantity();
        LocalDate expirationDate = fruitDto.getExpirationDate();
        if (LocalDate.now().isAfter(expirationDate)) {
            throw new RuntimeException("Fruit is already expired");
        }
        FruitStore.fruitStorage.put(fruit, FruitStore.fruitStorage.get(fruit) + quantity);
        FruitStore.expirationDateStorage.put(fruit, expirationDate);
    }
}
