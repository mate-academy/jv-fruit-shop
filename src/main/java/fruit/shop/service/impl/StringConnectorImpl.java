package fruit.shop.service.impl;

import fruit.shop.service.StringConnector;
import java.util.Map;

public class StringConnectorImpl implements StringConnector {

    @Override
    public String getStringReport(Map<String, Integer> records) {
        StringBuilder record = new StringBuilder();
        for (Map.Entry<String, Integer> entry : records.entrySet()) {
            record.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return record.toString();
    }
}
