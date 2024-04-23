package core.basesyntax.service.impl;

import core.basesyntax.model.FruitReport;
import core.basesyntax.service.FruitReportService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitReportServiceImpl implements FruitReportService {
    private final Map<String, BigDecimal> inventory;

    public FruitReportServiceImpl(Map<String, BigDecimal> inventory) {
        this.inventory = inventory;
    }

    @Override
    public List<FruitReport> generateInventoryReport() {
        List<FruitReport> reports = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> entry : inventory.entrySet()) {
            FruitReport report = new FruitReport();
            report.setFruit(entry.getKey());
            report.setQuantity(entry.getValue());
            reports.add(report);
        }
        return reports;
    }
}
