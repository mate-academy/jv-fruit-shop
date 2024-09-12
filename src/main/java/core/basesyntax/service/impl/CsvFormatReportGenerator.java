package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.service.ReportGenerator;
import java.util.stream.Collectors;

public class CsvFormatReportGenerator implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private static final String KEY_VALUE_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = "\n";
    private final FruitStorageDao fruitStorageDao;

    public CsvFormatReportGenerator(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        String reportData = fruitStorageDao.getAllFruits().stream()
                .map(fruit -> fruit + KEY_VALUE_SEPARATOR
                        + fruitStorageDao.getBalance(fruit))
                .collect(Collectors.joining(LINE_SEPARATOR));
        stringBuilder.append(HEADER).append(LINE_SEPARATOR).append(reportData);
        return stringBuilder.toString();
    }
}
