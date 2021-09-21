package myFruitShop.Service;

import myFruitShop.FruitStorage_DB.FruitStorage;
import myFruitShop.model.Fruit;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public String generateReport() {
        Map<Fruit, Integer> fruitStorageInfo =  FruitStorage.getStorage();
        StringBuilder dailyShopReport = new StringBuilder();
        dailyShopReport.append("fruit, quantity").append(System.lineSeparator());
        for (Map.Entry<Fruit,Integer> entry : fruitStorageInfo.entrySet()) {
           dailyShopReport.append(entry.getKey().getName()).append(",").append(entry.getValue()).append(System.lineSeparator());
        }
        return dailyShopReport.toString();
    }
}
