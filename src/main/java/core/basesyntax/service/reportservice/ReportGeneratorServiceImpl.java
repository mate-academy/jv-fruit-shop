package core.basesyntax.service.reportservice;

import core.basesyntax.dao.FruitStorageDao;
import java.util.Map;
import java.util.stream.Collectors;

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
        Map<String, Integer> allFruits = fruitStorageDao.getAllFruits();
        return HEADER + LINE_SEPARATOR + allFruits.entrySet().stream()
                .map(e -> e.getKey() + COMMA + e.getValue())
                .collect(Collectors.joining(LINE_SEPARATOR));
    }
}
