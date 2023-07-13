package db;

import java.util.Map;
import model.FruitTypes;

public class FruitStorage {
    private int bananaStock;
    private int appleStock;

    public FruitStorage() {
    }

    public int getBananaStock() {
        return bananaStock;
    }

    public void setBananaStock(int bananaStock) {
        this.bananaStock = bananaStock;
    }

    public int getAppleStock() {
        return appleStock;
    }

    public void setAppleStock(int appleStock) {
        this.appleStock = appleStock;
    }

    public void updateStock(Map<String,Integer> fruitData) {
        for (Map.Entry<String,Integer> entry : fruitData.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            if (fruit.equalsIgnoreCase(FruitTypes.BANANA.name())) {
                setBananaStock(quantity);
            } else if (fruit.equalsIgnoreCase(FruitTypes.APPLE.name())) {
                setAppleStock(quantity);
            }
        }
    }
}
