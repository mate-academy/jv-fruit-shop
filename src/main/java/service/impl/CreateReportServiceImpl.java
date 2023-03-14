package service.impl;

import dao.FruitDao;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitStore;
import service.CreateReportService;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private FruitDao fruitDao;
    private FruitStore fruitStore;

    public CreateReportServiceImpl(FruitDao fruitDao,
                                   FruitStore fruitStore) {
        this.fruitDao = fruitDao;
        this.fruitStore = fruitStore;
    }

    @Override
    public void generateReport() {
        Map<String, Integer> supplies = fruitStore.getSupplies();
        String report = supplies.entrySet()
                .stream()
                .map(entry -> entry.getKey()
                        + SEPARATOR
                        + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        TITLE + System.lineSeparator(),
                        ""));
        fruitDao.add(report);
    }
}
