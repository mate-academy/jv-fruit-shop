package core.basesyntax.service.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitModel;
import core.basesyntax.service.ReportWriter;

public class ReportWriterImpl implements ReportWriter {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        FruitModel[] fruitModels = FruitModel.values();
        report.append(REPORT_HEADER);
        for (FruitModel model : fruitModels) {
            Integer amount = Storage.fruitStorage.get(model);
            report.append(System.lineSeparator())
                    .append(model)
                    .append(SEPARATOR)
                    .append(amount);
        }
        return report.toString().toLowerCase();
    }
}
