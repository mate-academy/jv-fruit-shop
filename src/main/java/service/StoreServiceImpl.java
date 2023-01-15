package service;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class StoreServiceImpl implements StoreService {
    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit, quantity");
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder.append("\n")
                    .append(entry.getKey().getFruitName())
                    .append(",").append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
