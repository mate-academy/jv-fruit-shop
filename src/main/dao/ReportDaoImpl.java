package main.dao;

import main.db.Storage;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportDaoImpl implements ReportDao {
    private Storage storage = new Storage();

    @Override
    public Map<String, Integer> get() {
        return storage.getReportData();
    }

    @Override
    public void set(Map<String, Integer> report) {
        Map<String, Integer> currentReport = get();
        if (currentReport.isEmpty()) {
            storage.setReportData(report);
        }
        Map<String, Integer> updatedReport = Stream
            .concat(currentReport.entrySet().stream(), report.entrySet().stream())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                Integer::sum
            ));
        storage.setReportData(updatedReport);
    }
}
