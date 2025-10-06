package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : Storage.getSnapshot().entrySet()) {
            sb.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }

        return sb.toString();
    }
}
