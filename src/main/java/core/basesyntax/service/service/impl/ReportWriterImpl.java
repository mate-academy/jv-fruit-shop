package core.basesyntax.service.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitModel;
import core.basesyntax.service.ReportWriter;

public class ReportWriterImpl implements ReportWriter {

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        FruitModel[] fruitModels = FruitModel.values();
        report.append("fruit,quantity");
        for (FruitModel model : fruitModels) {
            String fruitType = model.getCode();
            Integer amount = Storage.fruitStorage.get(model);
            if (amount != null) {
                report.append(System.lineSeparator()).append(fruitType).append(",").append(amount);
            }
        }
        return report.toString();
    }
}
