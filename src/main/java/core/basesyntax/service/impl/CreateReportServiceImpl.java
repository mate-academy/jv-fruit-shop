package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.CreateReportService;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String HEADER = "fruit,quantity";
    private FruitDao fruitDao;

    public CreateReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String createReport() {
        String report = fruitDao.getAll();
        return HEADER + report;
    }
}
