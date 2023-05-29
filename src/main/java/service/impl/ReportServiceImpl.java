package service.impl;

import db.FruitsStorage;
import model.OutFileStructure;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public String getDataReport(OutFileStructure structure, FruitsStorage storage) {
        StringBuilder reportData = new StringBuilder();
        reportData.append(structure.getFruit()).append(COMMA_SEPARATOR)
                .append(structure.getQuantity())
                .append(System.lineSeparator());
        for (var node : storage.getFruitsStorage().entrySet()) {
            reportData.append(node.getKey())
                    .append(COMMA_SEPARATOR).append(node.getValue())
                    .append(System.lineSeparator());
        }
        return reportData.toString();
    }
}
