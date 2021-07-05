package service;

import java.util.Map;
import model.TheFruit;
import storage.TheStorage;

public class TheFruitReportImpl implements TheFruitReport {
    private static final String COMMA = ",";
    private static final String TITLE_RESULT = "fruit,quantity";

    @Override
    public String returnReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE_RESULT);
        for (Map.Entry<TheFruit,Integer> entry : TheStorage.iStorage.entrySet()) {
            stringBuilder.append(System.lineSeparator()).append(entry.getKey().getFruitName())
                    .append(COMMA).append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
