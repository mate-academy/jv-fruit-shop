package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreateReport;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CreateReportImpl implements CreateReport {
    private static final String HEAD = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder(HEAD);
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue());
        }
        return reportBuilder.toString().trim();
    }
}
