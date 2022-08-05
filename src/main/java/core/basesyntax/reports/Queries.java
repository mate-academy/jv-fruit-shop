package core.basesyntax.reports;

import java.util.Map;

public class Queries {
    public String totalFruitBalance(Map<String, Integer> data) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("fruit,quantity");
        data.forEach((key, value) -> stringBuffer
                .append(System.lineSeparator()).append(key).append(",").append(value));
        return stringBuffer.toString();
    }
}
