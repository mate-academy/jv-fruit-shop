package service.implementation;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String THIRD_COLUMN = "quantity";
    private static final String SECOND_COLUMN = "fruitType";
    private static final String COLUMN_SEPARATOR = ",";

    @Override
    public String getReport(List<FruitTransaction> fruitTransactionList) {
        StringBuilder builder = new StringBuilder();
        builder.append(SECOND_COLUMN)
                .append(COLUMN_SEPARATOR)
                .append(THIRD_COLUMN)
                .append(System.lineSeparator());
        StringBuilder report = builder.append(fruitTransactionList.stream()
                .map(f -> new StringBuilder().append(f.getFruit())
                        .append(COLUMN_SEPARATOR)
                        .append(f.getQuantity())
                        .append(System.lineSeparator()))
                .collect(Collectors.joining()));
        return report.toString();
    }
}
