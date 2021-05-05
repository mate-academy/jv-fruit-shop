package service.impl;

import db.Storage;
import java.util.Map;
import model.Fruit;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final char NEW_LINE_CHAR = '\n';
    private static final char SEPARATOR_CHAR = ',';

    @Override
    public String makeStockReportForCsvFile() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : Storage.fruits.entrySet()) {
            stringBuilder.append(fruitIntegerEntry.getKey()
                                                  .getFruitName())
                         .append(SEPARATOR_CHAR)
                         .append(fruitIntegerEntry.getValue())
                         .append(NEW_LINE_CHAR);
        }
        return stringBuilder.toString();
    }
}
