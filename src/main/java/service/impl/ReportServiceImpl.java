package service.impl;

import dao.FruitStorageDao;
import java.util.stream.Collectors;
import service.ReportService;

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
        String body = fruitStorageDao
                .getAllFruit()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + COMMA + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return HEADER + body;
    }
}
