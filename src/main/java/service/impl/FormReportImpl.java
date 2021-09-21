package service.impl;

import db.Storage;
import service.FormReport;

public class FormReportImpl implements FormReport {
    private static final String REPORT_HEAD = "fruit,quantity";

    @Override
    public String reportFromStorage() {
        StringBuilder stringBuilder = new StringBuilder(REPORT_HEAD);
        Storage.storage.forEach((key, value) -> stringBuilder.append(System.lineSeparator())
                .append(key.getName())
                .append(",")
                .append(value));
        return stringBuilder.toString();
    }
}
