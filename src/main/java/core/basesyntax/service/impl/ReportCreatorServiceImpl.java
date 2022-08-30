package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreatorService;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String CSV_FIRST_LINE = "fruit,quantity" + System.lineSeparator();
    private final StorageDao storageDao;

    public ReportCreatorServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String createReport() {
        Set<Fruit> data = storageDao.getAll();
        return CSV_FIRST_LINE
                + data.stream().map(
                        fruit -> fruit.getName()
                                + "," + storageDao.getAmount(fruit)
                                + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
