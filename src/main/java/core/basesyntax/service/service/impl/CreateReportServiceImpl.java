package core.basesyntax.service.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.CreatReportService;

public class CreateReportServiceImpl implements CreatReportService {
    public static final String FIRST_COLUMN_LINE = "fruit,quantity";
    public static final String COMA_SEPARATOR = ",";
    private final FruitDao fruitStorageDao;

    public CreateReportServiceImpl() {
        this.fruitStorageDao = new FruitDaoImpl();
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(FIRST_COLUMN_LINE);
        fruitStorageDao.getAll()
                .stream()
                .map(f -> f.getFruitType() + COMA_SEPARATOR + f.getQuantity())
                .forEach(s -> report.append(System.lineSeparator()).append(s));
        return report.toString();
    }
}
