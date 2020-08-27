package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import core.basesyntax.model.Storage;
import java.time.LocalDate;

public class StorageService<T> {
    private static final LocalDate DATE_NOW = LocalDate.now();

    public String getStorage() {
        int sumOfBananas = 0;
        for (FruitBox fruitBox : Storage.storage) {
            if (fruitBox.getExpiryDate().isAfter(DATE_NOW)
                    && fruitBox.getName().equals("banana")) {
                sumOfBananas = sumOfBananas + fruitBox.getAmount();
            }
        }
        StringBuilder resultString = new StringBuilder();
        resultString.append("banana")
                .append(",")
                .append(sumOfBananas);
        return resultString.toString();
    }
}
