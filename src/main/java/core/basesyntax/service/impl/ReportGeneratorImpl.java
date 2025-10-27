package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Constants;
import core.basesyntax.service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit");
        stringBuilder.append(Constants.COMA_SEPARATOR);
        stringBuilder.append("quantity");
        for (var elem : Storage.getFullStorage()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(elem.getKey());
            stringBuilder.append(Constants.COMA_SEPARATOR);
            stringBuilder.append(elem.getValue());
        }
        return stringBuilder.toString();
    }
}
