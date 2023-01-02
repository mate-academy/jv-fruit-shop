package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {

    @Override
    public String createReport() {
        int sumOfBananas = 0;
        int sumOfApples = 0;
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            if (entry.getKey().equals("banana")) {
                sumOfBananas = sumOfBananas + entry.getValue();
            }
            if (entry.getKey().equals("apple")) {
                sumOfApples = sumOfApples + entry.getValue();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator())
                .append("banana,").append(sumOfBananas).append(System.lineSeparator())
                .append("apple,").append(sumOfApples).append(System.lineSeparator());

        return stringBuilder.toString();
    }
}
