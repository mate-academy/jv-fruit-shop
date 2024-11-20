package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    private final FruitDB fruitDB;

    public ReportGenerator(FruitDB fruitDB) {
        this.fruitDB = fruitDB;
    }

    public List<String> generate() {
        List<String> report = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : fruitDB.getInventory().entrySet()) {
            report.add(entry.getKey() + "," + entry.getValue());
        }
        return report;
    }
}

