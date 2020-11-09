package core.basesyntax.service.impl;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.FruitDateAmountPair;
import core.basesyntax.model.FruitStorage;
import java.time.LocalDate;
import java.util.Map;

public class StorageService {
    private Map<String, FruitDateAmountPair> storage = FruitStorage.getFruitStorage();

    public FruitDateAmountPair addFruitToStorage(String fruitName, FruitDateAmountPair fruit) {
        return storage.put(fruitName, fruit);
    }

    public boolean checkIsFruitPresent(String key) {
        return storage.containsKey(key);
    }

    public FruitDateAmountPair getFruitFromStorage(
            FruitDto fruitDto, String key, Integer quantityToAdd) {
        FruitDateAmountPair fruit = storage.get(key);
        while (fruit.getNext() != null) {
            if (fruit.getDate().equals(fruitDto.getFruitDtoDate())) {
                fruit.setAmount(fruit.getAllFruitAmount() + quantityToAdd);
                return null;
            }
            fruit = fruit.getNext();
        }
        fruit.setNext(new FruitDateAmountPair(fruitDto.getFruitDtoDate(), quantityToAdd));
        return fruit;
    }

    public void extractFromStorage(Integer amount, LocalDate date, String key) {
        FruitDateAmountPair fruit = storage.get(key);
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
