package core.basesyntax.service;

import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private static final StringBuilder TITLE_FOR_RESULT = new StringBuilder("fruit,quantity");
    private static final String NEW_LINE = System.lineSeparator();
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";
    private static final String PUNCTUATION_MARK = ",";

    @Override
    public String getReportData(Map<String, Integer> reportMap) {
        return TITLE_FOR_RESULT.append(NEW_LINE)
                .append(BANANA)
                .append(PUNCTUATION_MARK)
                .append(reportMap.get(BANANA))
                .append(NEW_LINE)
                .append(APPLE)
                .append(PUNCTUATION_MARK)
                .append(reportMap.get(APPLE)).toString();
    }
}
