package service;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class StoreServiceImpl implements StoreService {
    @Override
    public String getService() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit, quantity");
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getFruitName())
                    .append(",").append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
