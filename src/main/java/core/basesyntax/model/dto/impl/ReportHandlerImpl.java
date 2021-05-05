package core.basesyntax.model.dto.impl;

import core.basesyntax.model.dto.ReportHandler;
import core.basesyntax.storage.DataBase;
import java.util.Map;

public class ReportHandlerImpl implements ReportHandler {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String COLUMN_SEPARATOR = ",";
    private Map<String, Integer> map;

    public ReportHandlerImpl(Map<String, Integer> map) {
        this.map = map;
    }

    public ReportHandlerImpl() {
        map = DataBase.getDataBase();
    }

    @Override
    public String makeReport() {
        StringBuilder report = new StringBuilder();
        String reportString = "";
        report.append(FIRST_LINE)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            report.append(entry.getKey())
                    .append(COLUMN_SEPARATOR)
                    .append(entry.getValue().toString())
                    .append(System.lineSeparator());
            reportString = report.toString();
        }
        return reportString;
    }
}
