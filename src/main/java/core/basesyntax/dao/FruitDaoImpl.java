package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Integer add(String fruitName, int amount) {
        return Storage.fruits.containsKey(fruitName)
                ? Storage.fruits.replace(fruitName, Storage.fruits.get(fruitName) + amount)
                : Storage.fruits.put(fruitName, amount);

    }

    @Override
    public boolean writeReportToFile(String fileName, String report) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.append(report);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
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
