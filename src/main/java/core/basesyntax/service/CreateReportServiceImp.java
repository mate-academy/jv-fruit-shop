package core.basesyntax.service;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImp;

public class CreateReportServiceImp implements CreatReportService {
    public static final String FIRST_COLUMN_LINE = "fruit,quantity";
    public static final String COMA_SEPARATOR = ",";
    private final FruitStorageDao fruitStorageDao;

    public CreateReportServiceImp() {
        this.fruitStorageDao = new FruitStorageDaoImp();
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
