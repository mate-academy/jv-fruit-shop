package impl;

import db.Storage;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private static final String FRUITANDQUANTITY = "fruit, quantity";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(FRUITANDQUANTITY);
        Storage.dataBase.forEach((key, value) -> stringBuilder
                .append(System.lineSeparator())
                .append(key)
                .append(SEPARATOR)
                .append(value)
        );
        return stringBuilder.toString();
    }
}
