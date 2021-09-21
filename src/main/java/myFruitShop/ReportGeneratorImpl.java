package myFruitShop;

import myFruitShop.FruitStorage.FruitStorage;
import myFruitShop.model.Fruit;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator{
    public String generateReport() {
        Map<Fruit, Integer> fruitStorageInfo =  FruitStorage.getStorage();
        StringBuilder dailyShopReport = new StringBuilder();
        for (Map.Entry<Fruit,Integer> entry : fruitStorageInfo.entrySet()) {
           dailyShopReport.append(entry.getKey().getName()).append(",").append(entry.getValue()).append(System.lineSeparator());
        }
        return dailyShopReport.toString();
    }
}
