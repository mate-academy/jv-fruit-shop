package fruit.shop.service.impl;

import fruit.shop.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String createString(Map<String, Integer> balanceMap) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        StringBuilder resultString = stringBuilder.append(System.lineSeparator());
        if (balanceMap.isEmpty()) {
            throw new RuntimeException("DB is Empty nothing to write");
        }
        for (Map.Entry<String,Integer> entry : balanceMap.entrySet()) {
            resultString.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return resultString.toString();
    }
}
