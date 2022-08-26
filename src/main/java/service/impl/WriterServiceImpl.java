package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import model.FruitTransaction;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String TITLE_FOR_REPORT = "fruit,quantity";
    private static final String BANANA = "banana";
    private static final String APPLE = "apple";
    private static final String SEPARATOR = ",";

    @Override
    public void createReport(List<FruitTransaction> transactions, String fileName) {
        int amountOfApples = transactions.stream()
                .filter(f -> f.getFruit().equals(APPLE))
                .mapToInt(FruitTransaction::getQuantity)
                .sum();
        int amountOfBananas = transactions.stream()
                .filter(f -> f.getFruit().equals(BANANA))
                .mapToInt(FruitTransaction::getQuantity)
                .sum();
        StringBuilder stringBuilder = new StringBuilder();
        String report = stringBuilder.append(TITLE_FOR_REPORT).append(System.lineSeparator())
                .append(BANANA).append(SEPARATOR).append(amountOfBananas)
                .append(System.lineSeparator())
                .append(APPLE).append(SEPARATOR).append(amountOfApples).toString();
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }
        try {
            Files.write(file.toPath(), report.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
