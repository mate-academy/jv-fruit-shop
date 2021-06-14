package core.basesyntax.reportcreator;

import java.util.List;

public class CsvReporter implements ReportCreator {
    private static final String CSV_HEADER = "fruit,quantity";

    @Override
    public String createReport(List<String> data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CSV_HEADER);
        stringBuilder.append('\n');

        for (String word : data) {
            stringBuilder.append(word);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
