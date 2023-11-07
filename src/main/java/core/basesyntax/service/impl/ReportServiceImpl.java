package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final int DEFAULT_QUANTITY = 0;
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private FruitStorageDao fruitStorageDao;

    public ReportServiceImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public String generateReport() {
        String body = fruitStorageDao.getAllFruit().entrySet().stream()
                .map(entry -> entry.getKey() + COMMA + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return HEADER + body;
    }
}
