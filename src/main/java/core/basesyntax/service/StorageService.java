package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import java.time.LocalDate;

public class StorageService<T> {
    private static final LocalDate DATE_NOW = LocalDate.now();
    private static final String BANANA_FRUIT_TYPE = "banana";

    public String getStorage() {
        int sumOfFruits = 0;
        for (FruitBox fruitBox : Storage.storage) {
            if (fruitBox.getExpiryDate().isAfter(DATE_NOW)
                    && fruitBox.getName().equals(BANANA_FRUIT_TYPE)) {
                sumOfFruits += fruitBox.getAmount();
            }
        }
        StringBuilder resultString = new StringBuilder();
        resultString.append("banana")
                .append(",")
                .append(sumOfFruits);

        return resultString.toString();
    }
}
