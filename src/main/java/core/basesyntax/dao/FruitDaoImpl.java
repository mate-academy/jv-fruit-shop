package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Optional<Fruit> get(String fruitName) {
        return Storage.fruits.stream().filter(f -> f.getName().equals(fruitName)).findFirst();
    }

    @Override
    public boolean update(String fruitName, int amount) {
        Optional<Fruit> fruit = get(fruitName);
        if (fruit.isEmpty()) {
            return createFruit(fruitName, amount);
        }
        Storage.fruits.remove(fruit.get());
        return Storage.fruits.add(new Fruit(fruitName, fruit.get().getAmount() + amount));
    }

    @Override
    public boolean writeReportToFile(String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/" + fileName));
            writer.append("type,fruit\n");
            for (Fruit fruit : Storage.fruits) {
                writer.append(fruit.getName() + "," + fruit.getAmount() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private static boolean createFruit(String fruitName, int amount) {
        return Storage.fruits.add(new Fruit(fruitName, amount));
    }

}
