package core.basesyntax.service;

import core.basesyntax.db.DbManagerImpl;
import core.basesyntax.model.FruitResultingRow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportSaverImpl implements ReportSaver {
    @Override
    public void saveReport(Map<String, Integer> report) {
        DbManagerImpl.getInstance().putAll(convertReportToListOfCsvRows(report));
    }

    private List<FruitResultingRow> convertReportToListOfCsvRows(Map<String, Integer> report) {
        List<FruitResultingRow> listOfResultingStrings = new ArrayList<>();
        for (var entity : report.entrySet()) {
            listOfResultingStrings.add(new FruitResultingRow(entity.getKey(), entity.getValue()));
        }
        return listOfResultingStrings;
    }
}
