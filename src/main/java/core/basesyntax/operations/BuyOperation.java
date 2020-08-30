package core.basesyntax.operations;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitDto;
import java.time.LocalDate;
import java.util.Map;

public class BuyOperation implements Operation {
    private Map<String, Fruit> storage = Fruit.getFruitStorage();

    @Override
    public void doOperation(FruitDto fruitDto) {
        String key = fruitDto.getFruitName();
        if (storage.containsKey(key)) {
            LocalDate dateFromTransaction = fruitDto.getFruitDtoDate();
            Integer amountToSubtract = fruitDto.getAmount();
            extractFromStorage(amountToSubtract, dateFromTransaction, key);
        } else {
            throw new RuntimeException("We do not have this fruit.");
        }
    }

    private void extractFromStorage(Integer amount, LocalDate date, String key) {
        Fruit fruit = storage.get(key);
        if (fruit.getAllFruitAmountByDate(date) < amount) {
            throw new RuntimeException("We are out of this fruit.");
        }
        while (fruit != null) {
            if (fruit.getDate().isAfter(date)) {
                if (fruit.getAmount() >= amount) {
                    fruit.setAmount(fruit.getAmount() - amount);
                    return;
                }
                int difference = amount - fruit.getAmount();
                fruit.setAmount(0);
                amount = difference;
            }
            if (amount == 0) {
                storage.put(key, fruit);
                return;
            }
            fruit = fruit.getNext();
        }
    }
}
