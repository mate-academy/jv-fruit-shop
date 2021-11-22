package core.basesyntax.service;

import java.util.List;

public class DataParser {
    private static final String TITLE_LINE = "fruit,quantity";
    private static final int TITLE_LINE_INDEX = 0;

    public String formatReport(List<String> data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE_LINE)
                .append(System.lineSeparator());
        data.forEach(l -> stringBuilder.append(l).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }

    public List<String> formatInputData(List<String> data) {
        data.remove(TITLE_LINE_INDEX);
        return data;
    }
}
