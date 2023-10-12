package fruit.shop.service.impl;

import fruit.shop.service.CreaterReport;
import java.util.Map;

public class CreaterReportImpl implements CreaterReport {
    @Override
    public String createString(Map<String, Integer> balanceMap) {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity");
        StringBuilder resultString = stringBuilder.append(System.lineSeparator());
        for (Map.Entry<String,Integer> entry : balanceMap.entrySet()) {
            resultString.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return resultString.toString();
    }
}
