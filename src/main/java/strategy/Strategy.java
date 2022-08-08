package strategy;

import java.util.List;
import service.FruitService;
import service.impl.FruitServiceImpl;

public class Strategy {
    private FruitService fruitService = new FruitServiceImpl();

    public String getReport() {
        return fruitService.getFruitReport();
    }

    private void balance(String name, int amount) {
        fruitService.put(name, amount);
    }

    private void supply(String name, int amount) {
        int add = fruitService.get(name);
        fruitService.put(name, add + amount);
    }

    private void purchase(String name, int amount) {
        int bought = fruitService.get(name);
        fruitService.put(name, bought - amount);
    }

    public void operation(List<String> lines) {
        for (String line : lines) {
            String[] data = line.split(",");
            switch (data[0].trim()) {
                case "b":
                    balance(data[1], Integer.parseInt(data[2]));
                    break;
                case "s":
                    supply(data[1], Integer.parseInt(data[2]));
                    break;
                case "p":
                    purchase(data[1], Integer.parseInt(data[2]));
                    break;
                case "r":
                    supply(data[1], Integer.parseInt(data[2]));
                    break;
                default:
                    break;
            }
        }
    }
}
