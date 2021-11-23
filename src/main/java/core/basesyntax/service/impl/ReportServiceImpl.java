package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity";
    private FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        return TITLE + System.lineSeparator() + fruitDao.getAll().entrySet().stream()
                .map(e -> "" + e.getKey().getName() + "," + e.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
