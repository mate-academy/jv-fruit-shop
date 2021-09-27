package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.service.inter.FruitReportService;
import java.util.Map;

public class FruitReportServiceImpl implements FruitReportService {
    @Override
    public String createReport() {
        StringBuilder result = new StringBuilder("fruit, quantity" + "\n");

        for (Map.Entry<String, Integer> fruit: Storage.fruitsQuantity.entrySet()) {
            result.append(fruit).append("\n");
        }
        return result.toString();
    }
}
