package core.basesyntax.service.fileoperation.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.fileoperation.CreateReport;

public class CreateReportImpl implements CreateReport {
    private static final String TITLE = "fruit,quantity";
    private final StringBuilder builder = new StringBuilder();
    private final StorageDao dao = new StorageDaoImpl();

    @Override
    public String getReport() {
        builder.append(TITLE);
        builder.append(System.lineSeparator());
        for (Fruit storage: dao.getAll()) {
            builder.append(storage.getName());
            builder.append(",");
            builder.append(storage.getAmountFruit());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
