package core.basesyntax.strategy;

import core.basesyntax.FruitStorage;
import core.basesyntax.model.FruitBatch;
import core.basesyntax.model.FruitDto;
import java.time.LocalDate;
import java.util.Map;

public class BuyTransaction implements FruitTransaction {

    @Override
    public void apply(FruitDto fruitDto) {
        Map<FruitBatch, Integer> fruits = FruitStorage.getFruits();
        int quantity = fruitDto.getQuantity();
        LocalDate purchaseDate = fruitDto.getDate();
        boolean foundFruit = false;
        for (Map.Entry<FruitBatch, Integer> entry : fruits.entrySet()) {
            if (entry.getKey().getFruitType().equals(fruitDto.getFruitType())) {
                if (entry.getKey().getExpiryDate().isAfter(purchaseDate)) {
                    if (entry.getValue() < quantity) {
                        throw new RuntimeException("Arithmetic "
                                + "error. There wasn't"
                                + " enough fruit in the store to "
                                + "make the purchase.");
                    }
                    entry.setValue(entry.getValue() - quantity);
                    foundFruit = true;
                }
            }
        }
        if (!foundFruit) {
            throw new RuntimeException("There are no "
                    + fruitDto.getFruitType() + "s in the store.");
        }
    }
}
