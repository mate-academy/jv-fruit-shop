package core.basesyntax.service.fileoperation.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.fileoperation.CreateReport;

public class CreateReportImpl implements CreateReport {
    private static final String TITLE = "fruit,quantity";
    private final StringBuilder builder;
    private final StorageDao dao;

    public CreateReportImpl(StringBuilder builder, StorageDao dao) {
        this.builder = builder;
        this.dao = dao;
    }

    @Override
    public String getReport() {
        builder.append(TITLE);
        builder.append(System.lineSeparator());
        for (Fruit fruit: dao.getAll()) {
            builder.append(fruit.getName());
            builder.append(",");
            builder.append(fruit.getAmountFruit());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
