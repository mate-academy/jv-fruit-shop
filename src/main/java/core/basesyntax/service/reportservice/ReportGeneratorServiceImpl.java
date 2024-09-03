package core.basesyntax.service.reportservice;

import core.basesyntax.dao.FruitStorageDao;

import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String HEADER = "fruit,quantity";
    private static final String COMMA = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private FruitStorageDao fruitStorageDao;

    public ReportGeneratorServiceImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public String createReportFromDb() {
        StringBuilder sb = new StringBuilder(HEADER);
        sb.append(LINE_SEPARATOR);
        Map<String, Integer> allFruits = fruitStorageDao.getAllFruits();
        for (Map.Entry entry : allFruits.entrySet()) {
            sb.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return sb.toString();
    }
}
