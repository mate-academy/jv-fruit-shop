package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGeneratorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    @Override
    public List<String> generate() {
        List<String> strings = new ArrayList<>();
        strings.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            strings.add(entry.getKey() + "," + entry.getValue());
        }
        return strings;
    }
}
