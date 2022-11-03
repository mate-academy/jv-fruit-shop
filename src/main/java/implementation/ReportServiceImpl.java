package implementation;

import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";

    @Override
    public String writeReport(Map<String, Integer> fruits) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append("\n");
        fruits.forEach((key, value) -> builder.append(key)
                .append(COMMA).append(value).append("\n"));
        return builder.toString();
    }
}
