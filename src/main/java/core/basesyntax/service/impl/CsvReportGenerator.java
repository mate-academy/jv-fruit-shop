package core.basesyntax.service.impl;

import core.basesyntax.dao.InventoryDao;
import core.basesyntax.dao.InventoryDaoImpl;
import core.basesyntax.service.ReportGenerator;
import java.util.Map.Entry;

public class CsvReportGenerator implements ReportGenerator {
    private static final String COMA = ",";
    private static final String CSV_FIRST_LINE = "fruit, quantity";
    private final InventoryDao inventoryDao;

    public CsvReportGenerator() {
        this.inventoryDao = new InventoryDaoImpl();
    }

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CSV_FIRST_LINE).append(System.lineSeparator());
        for (Entry<String, Integer> entry : inventoryDao.getCurrentInventoryState().entrySet()) {
            stringBuilder.append(entry.getKey()).append(COMA);
            stringBuilder.append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
