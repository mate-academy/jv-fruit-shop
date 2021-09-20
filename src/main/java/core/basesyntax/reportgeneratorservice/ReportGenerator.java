package core.basesyntax.reportgeneratorservice;

import java.util.HashMap;
import java.util.Map;

public interface ReportGenerator {
    String FILE_REPORT_NAME = "src/main/resources/report.txt";
    String SOURCE_FILE_NAME = "src/main/resources/filetest";
    String HEADER = "fruit,quantity" + System.lineSeparator();

    default String mapToStringConverter(HashMap<String, Integer> stringIntegerMap) {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        for (Map.Entry<String, Integer> map : stringIntegerMap.entrySet()) {
            stringBuilder.append(map.getKey())
                    .append(",")
                    .append(map.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
