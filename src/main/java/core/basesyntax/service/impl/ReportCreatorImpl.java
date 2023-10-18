package core.basesyntax.service.impl;

import core.basesyntax.database.StorageDaoImpl;
import core.basesyntax.service.ReportCreator;

public class ReportCreatorImpl implements ReportCreator {
    private static final String COMA = ",";
    private static final String FIRST_LINE_IN_REPORT = "fruit,quantity";
    private StorageDaoImpl storageDao;

    public ReportCreatorImpl() {
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIRST_LINE_IN_REPORT);
        storageDao.getAll().stream()
                .map(f -> f.getFruitName() + COMA + f.getQuantity())
                .forEach(s -> stringBuilder.append(System.lineSeparator()).append(s));

        return stringBuilder.toString();
    }
}

