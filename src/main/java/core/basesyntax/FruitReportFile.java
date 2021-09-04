package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitReportFile {
    public void report(String fileName) {
        List<FruitListOperation> fruitListOperations = new FruitsFileReader().read(fileName);
        Map<String, Fruit> fruits = new HashMap<>();
        for (int i = 0; i < fruitListOperations.size(); i++) {
            switch (fruitListOperations.get(i).getFruitOperation()) {
                case "b":
                    new FruitServisImpl().balanceFruit(fruitListOperations.get(i), fruits);
                    break;
                case "s":
                    new FruitServisImpl().supplyFruit(fruitListOperations.get(i), fruits);
                    break;
                case "p":
                    new FruitServisImpl().purchaseFruit(fruitListOperations.get(i), fruits);
                    break;
                case "r":
                    new FruitServisImpl().returnFruit(fruitListOperations.get(i), fruits);
                    break;
                default:
                    break;
            }
        }
        System.out.println("fruit,quantity");
        for (Fruit fruit : fruits.values()) {
            System.out.println(fruit.getName() + "," + fruit.getQuantity());
        }
    }
}
