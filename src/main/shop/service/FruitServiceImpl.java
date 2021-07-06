package service;

import db.Storage;
import model.Fruit;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String SYMBOL_FOR_SEPARATING = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> storage : Storage.storage.entrySet()) {
            stringBuilder.append(storage.getKey().getName())
                    .append(SYMBOL_FOR_SEPARATING)
                    .append(storage.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
