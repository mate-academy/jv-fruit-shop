package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import java.util.Map;
import java.util.Set;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final char SEPARATOR = ',';

    @Override
    public String getReport(ShopService service) {
        Map<String, Integer> fruitMap = service.getStorage();
        Set<String> fruits = fruitMap.keySet();
        StringBuilder sb = new StringBuilder();
        for (String fruit : fruits) {
            sb.append(System.lineSeparator())
                    .append(fruit)
                    .append(SEPARATOR)
                    .append(fruitMap.get(fruit));
        }
        return sb.substring(1);
    }
}
