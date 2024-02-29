package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Integer add(String fruitName, int amount) {
        return Storage.fruits.containsKey(fruitName)
                ? Storage.fruits.replace(fruitName, Storage.fruits.get(fruitName) + amount)
                : Storage.fruits.put(fruitName, amount);

    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append("type,fruit\n");
        for (Map.Entry<String, Integer> fruit : Storage.fruits.entrySet()) {
            report.append(fruit.getKey() + "," + fruit.getValue() + "\n");
        }
        return report.toString();
    }
}
