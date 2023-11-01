package service.impl;

import java.util.HashMap;
import java.util.Map;
import service.ReportGenerator;
public class CsvReportGenerator implements ReportGenerator {
    private static final String COMA = ",";
    private static final String CSV_FIRST_LINE = "fruit, quantity";
    InventoryDaoImpl inventoryDao = new InventoryDaoImpl();
    @Override
    public String generateReport(HashMap<String, Integer> inventoryMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CSV_FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : inventoryDao.getInventoryMap().entrySet()) {
            stringBuilder.append(entry.getKey()).append(COMA);
            stringBuilder.append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
