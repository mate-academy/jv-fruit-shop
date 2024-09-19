package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import java.util.Map;
import java.util.Set;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(ShopService service) {
        Storage storage = service.getStorage();
        Map<String, Integer> fruitMap = storage.getAll();
        Set<String> fruits = fruitMap.keySet();
        StringBuilder sb = new StringBuilder();
        for (String fruit : fruits) {
            sb.append("\n").append(fruit).append(",").append(fruitMap.get(fruit));
        }
        return sb.substring(1);
    }
}
