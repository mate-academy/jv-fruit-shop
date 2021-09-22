package fruitshop.service.reporthandlers;

import fruitshop.fruitstoragedb.FruitStorage;
import fruitshop.model.Fruit;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit, quantity";

    public String generateReport() {
        StringBuilder dailyShopReport = new StringBuilder();
        dailyShopReport.append(REPORT_HEADER).append(System.lineSeparator());
        for (Map.Entry<Fruit,Integer> entry : FruitStorage.getStorage().entrySet()) {
            dailyShopReport.append(entry.getKey().getName())
                    .append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return dailyShopReport.toString();
    }
}
