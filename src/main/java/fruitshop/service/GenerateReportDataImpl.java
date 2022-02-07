package fruitshop.service;

import java.util.List;

public class GenerateReportDataImpl implements GenerateReportDataService {
    private static final String COLUMN_NAME_ONE = "fruit";
    private static final String COLUMN_NAME_TWO = "quality";

    @Override
    public String report(List<String> data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(COLUMN_NAME_ONE + "," + COLUMN_NAME_TWO)
                .append(System.lineSeparator());
        for (String line : data) {
            stringBuilder.append(line)
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
