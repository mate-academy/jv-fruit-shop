package mate.academy.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.model.Fruit;
import mate.academy.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String TABLE_COLUMN_FIRST = "fruit";
    private static final String TABLE_COLUMN_SECOND = "quantity";
    private static final String TABLE_COLUMN_SEPARATOR = ",";
    private static final String STRINGS_SEPARATOR = System.lineSeparator();

    @Override
    public String getReport(List<Fruit> fruitList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TABLE_COLUMN_FIRST)
                .append(TABLE_COLUMN_SEPARATOR)
                .append(TABLE_COLUMN_SECOND)
                .append(STRINGS_SEPARATOR);
        return stringBuilder
                .append(fruitList.stream()
                .map(f -> new StringBuilder().append(f.getFruit())
                        .append(TABLE_COLUMN_SEPARATOR)
                        .append(f.getQuantity())
                        .append(STRINGS_SEPARATOR))
                .collect(Collectors.joining()))
                .toString();
    }
}
