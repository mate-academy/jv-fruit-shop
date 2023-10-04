package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportsService;
import java.util.ArrayList;
import java.util.List;

public class FinalReport implements ReportsService {
    private static final String FIRST_LINE = "fruit,quantity";

    @Override
    public List<String> getReport() {
        FruitDaoImpl storage = new FruitDaoImpl();
        List<String> report = new ArrayList<>();
        report.add(FIRST_LINE);
        storage.getStorage()
                .forEach((key, value) -> report.add(key + "," + value));
        return report;
    }
}
