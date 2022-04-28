package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.storage.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private List<String> report = new ArrayList<>();

    @Override
    public List<String> report() {
        report.add("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitStorage.entrySet()) {
            report.add(entry.getKey().getFruit() + "," + entry.getValue().toString());
        }
        return report;
    }
}
