package model;

import exception.FruitShopException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentBalance {
    public Map<Fruit, Integer> balanceMap = new HashMap<>();
    public List<Fruit> fruitList = new ArrayList<>();

    public void addBalance(Fruit fruit, Integer quantity) {
        fruitList.add(fruit);
        balanceMap.put(fruit, quantity);
    }

    public void saveOutPut(String outputFileName) {
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {
            writter.write("fruit,quantity\n");
            for (Fruit fruit : fruitList) {
                writter.write(fruit.name + "," + balanceMap.get(fruit).toString() + "\n");
            }
        } catch (IOException e) {
            throw new FruitShopException("File can't be saved");
        }
    }
}
