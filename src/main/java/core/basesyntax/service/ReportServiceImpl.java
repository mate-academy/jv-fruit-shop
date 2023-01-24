package core.basesyntax.service;

import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_FOR_RESULT = "fruit,quantity";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String PUNCTUATION_MARK = ",";

    @Override
    public String getReportData(Map<String, Integer> reportMap) {
        StringBuilder stringBuilder = new StringBuilder(TITLE_FOR_RESULT);
        for (Map.Entry<String, Integer> element : reportMap.entrySet()) {
            stringBuilder.append(NEW_LINE)
                    .append(element.getKey())
                    .append(PUNCTUATION_MARK)
                    .append(element.getValue());
        }
        return stringBuilder.toString();
    }
}