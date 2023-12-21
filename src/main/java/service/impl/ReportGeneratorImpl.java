package service.impl;

import db.FruitStorage;
import java.util.Map;
import service.ReportGenerator;

//Report example:
//fruit,quantity
//banana,152
//apple,90
public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReportFromDB() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("fruit,quantity");

        for (Map.Entry<String, Integer> entry : FruitStorage.storage.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey()).append(",").append(entry.getValue());
        }

        return stringBuilder.toString();
    }
}
