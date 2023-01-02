package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    public static final String BANANA = "banana";
    public static final String APPLE = "apple";

    @Override
    public String createReport() {
        int sumOfBananas = 0;
        int sumOfApples = 0;
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            if (entry.getKey().equals(BANANA)) {
                sumOfBananas = sumOfBananas + entry.getValue();
            }
            if (entry.getKey().equals(APPLE)) {
                sumOfApples = sumOfApples + entry.getValue();
            }
        }

        return "fruit,quantity" + System.lineSeparator() +
                BANANA + "," + sumOfBananas + System.lineSeparator() +
                APPLE + "," + sumOfApples + System.lineSeparator();
    }
}
