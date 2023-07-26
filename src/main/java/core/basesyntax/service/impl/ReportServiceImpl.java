package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER_LINE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public List<String> generateReport() {
        List<String> reportLines = new ArrayList<>();
        reportLines.add(HEADER_LINE);
        for (FruitTransaction fruit : FruitStorage.getAllFruits()) {
            reportLines.add(fruit.getFruit() + SEPARATOR + fruit.getQuantity());
        }
        return reportLines;
    }
}
