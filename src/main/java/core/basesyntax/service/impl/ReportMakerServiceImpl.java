package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportMakerService;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String CSV_SEPARATOR = ",";
    private static final String FRUITS_TITLE = "fruit";
    private static final String QUANTITY_TITLE = "quantity";

    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder(rowMaker(FRUITS_TITLE, QUANTITY_TITLE));
        Storage.fruits.entrySet()
                .stream()
                .forEach(entry -> stringBuilder.append(
                        rowMaker(entry.getKey(),entry.getValue().toString())
                ));

        return stringBuilder.toString();
    }

    private String rowMaker(String firstColumn, String secondColumn) {
        return firstColumn + CSV_SEPARATOR + secondColumn + System.lineSeparator();
    }
}
