package service.impl;

import db.Storage;
import java.util.Map;
import model.Fruit;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> set : Storage.fruits.entrySet()) {
            builder.append(set.getKey().getName())
                    .append(",").append(set.getValue())
                    .append("\n");
        }
        return builder.toString();
    }
}
