package service.report;

import model.FruitRecord;

import java.util.List;

public interface ReportService {
    String getReport(List<FruitRecord> fruitRecords);
}
