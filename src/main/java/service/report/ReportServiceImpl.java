package service.report;

import dao.Storage;
import model.FruitRecord;

import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String FRUIT = "fruit";
    private static final String QUANTITY = "quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport(List<FruitRecord> fruitRecords) {
        StringBuilder report = new StringBuilder();
        report.append(FRUIT).append(COMMA).append(QUANTITY).append(System.lineSeparator());

        Storage.storage.forEach((fruit, quantity) -> report
                .append(fruit).append(COMMA).append(quantity).append(System.lineSeparator()));
        return report.toString();
    }
}
