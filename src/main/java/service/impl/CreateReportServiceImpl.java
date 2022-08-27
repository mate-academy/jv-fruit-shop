package service.impl;

import model.FruitTransaction;
import service.CreateReportService;

import java.util.List;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String TITLE_FOR_REPORT = "fruit,quantity";
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport(List<FruitTransaction> transactions) {
        int amountOfApples = transactions.stream()
                .filter(f -> f.getFruit().equals(APPLE))
                .mapToInt(FruitTransaction::getQuantity)
                .sum();
        int amountOfBananas = transactions.stream()
                .filter(f -> f.getFruit().equals(BANANA))
                .mapToInt(FruitTransaction::getQuantity)
                .sum();
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(TITLE_FOR_REPORT).append(System.lineSeparator())
                .append(BANANA).append(SEPARATOR).append(amountOfBananas)
                .append(System.lineSeparator())
                .append(APPLE).append(SEPARATOR).append(amountOfApples).toString();
    }
}
