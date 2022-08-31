package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String CSV_SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> list = new ArrayList<>();
        list.add(HEADER);
        for (Map.Entry<Fruit, Integer> entry : Storage.stock.entrySet()) {
            list.add(entry.getKey() + CSV_SEPARATOR + entry.getValue());
        }
        return list;
    }
}
