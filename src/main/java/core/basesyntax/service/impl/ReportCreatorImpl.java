package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.reportcreator.ReportCreator;

import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private final StorageDao storage;
    private final String fruitColumnName = "fruit";
    private final String fruitAmountColumnName = "quantity";
    private final String columnSeparator = ",";

    public ReportCreatorImpl() {
        storage = new StorageDaoImpl();
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append(fruitColumnName).append(columnSeparator).append(fruitAmountColumnName);
        for (Map.Entry<String, Integer> product : storage.getStock().entrySet()) {
            report.append(System.lineSeparator())
                    .append(product.getKey())
                    .append(columnSeparator)
                    .append(product.getValue());
        }
        return report.toString();
    }
}
