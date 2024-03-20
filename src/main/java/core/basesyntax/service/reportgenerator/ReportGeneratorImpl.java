package core.basesyntax.service.reportgenerator;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String SPLITTER = ",";

    @Override
    public List<String> getReport() {
        List<String> report = new ArrayList<>();
        report.add(HEADER);
        Map<Fruit, Integer> fruits = Storage.fruits;
        for (Map.Entry<Fruit, Integer> entry : fruits.entrySet()) {
            Fruit fruit = entry.getKey();
            int quantity = entry.getValue();
            String fruitReport = fruit.name() + SPLITTER + quantity;
            report.add(fruitReport);
        }
        return report;
    }
}
