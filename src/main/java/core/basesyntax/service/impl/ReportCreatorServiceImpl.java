package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreatorService;

import java.util.List;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService<List<Fruit>> {
    private static final String CSV_FIRST_LINE = "fruit,quantity" + System.lineSeparator();
    private final StorageDao storageDao;

    public ReportCreatorServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport(List<Fruit> data) {
        return CSV_FIRST_LINE
                + data.stream().map(
                        fruit -> fruit.getName()
                        + "," + storageDao.getAmount(fruit)
                        + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
