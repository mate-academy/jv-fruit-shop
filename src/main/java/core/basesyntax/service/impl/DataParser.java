package core.basesyntax.service.impl;

import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class DataParser implements Parser {
    private static final String INPUT_TITLE_LINE = "type,fruit,quantity";
    private static final String OUTPUT_TITLE_LINE = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String formatReport(List<String> data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OUTPUT_TITLE_LINE)
                .append(System.lineSeparator());
        data.forEach(l -> stringBuilder.append(l).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }

    @Override
    public List<String[]> formatInputData(List<String> data) {
        return data.stream()
                .filter(l -> !l.equals(INPUT_TITLE_LINE))
                .map(l -> l.split(SEPARATOR)).collect(Collectors.toList());
    }
}
