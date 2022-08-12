package core.service;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String CHAR_FOR_SPLIT = ",";

    @Override
    public String create(Map<String, Integer> data) {
        return data.entrySet()
            .stream()
            .map(stringIntegerEntry -> stringIntegerEntry.getKey() + CHAR_FOR_SPLIT
                    + stringIntegerEntry.getValue())
            .collect(Collectors.joining(System.getProperty("line.separator")));
    }
}
