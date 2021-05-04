package service.impl;

import db.Storage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import model.Fruit;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final char NEW_LINE_CHAR = '\n';
    private static final char SEPARATOR_CHAR = ',';
    private static final String ERROR_MESSAGE = "Can`t write to file ";

    @Override
    public void makeStockReportToCsvFile(String outputFileName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : Storage.fruits.entrySet()) {
            stringBuilder.append(fruitIntegerEntry.getKey()
                                                  .getFruitName())
                         .append(SEPARATOR_CHAR)
                         .append(fruitIntegerEntry.getValue())
                         .append(NEW_LINE_CHAR);
        }
        Path path = Path.of(outputFileName);
        try {
            Files.write(path, stringBuilder.toString()
                                           .getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println(ERROR_MESSAGE + outputFileName);
        }
    }
}
