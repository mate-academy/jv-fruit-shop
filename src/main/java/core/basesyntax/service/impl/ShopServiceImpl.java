package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ShopService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService<String> {
    private static final String FIRST_LINE_IN_REPORT = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(FIRST_LINE_IN_REPORT);
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",").append(entry.getValue());
            report.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return report;
    }
}
