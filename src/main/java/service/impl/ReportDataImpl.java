package service.impl;

import db.Storage;
import java.util.stream.Collectors;
import service.ReportData;

public class ReportDataImpl implements ReportData {
    private static final String TITLE_FOR_RESIT = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String creatReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE_FOR_RESIT).append(System.lineSeparator());
        Storage.getFruitsMap()
                .entrySet()
                .stream()
                .map(e -> stringBuilder.append(e.getKey())
                        .append(SEPARATOR)
                        .append(e.getValue())
                        .append(System.lineSeparator()))
                .collect(Collectors.joining());
        return stringBuilder.toString();
    }
}
