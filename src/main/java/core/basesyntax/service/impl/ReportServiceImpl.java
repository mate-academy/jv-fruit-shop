package core.basesyntax.service.impl;

import core.basesyntax.db.InMemoryStorage;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<String> report() {
        List<String> strings = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : InMemoryStorage.items.entrySet()) {
            String stringBuilder = entry.getKey() + "," + entry.getValue();
            strings.add(stringBuilder);
        }
        return strings;
    }
}
