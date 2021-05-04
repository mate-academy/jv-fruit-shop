package service.impl;

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
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";
    private static final String ERROR_MESSAGE = "Can`t write to file ";

    @Override
    public void makeStockReportToCsvFile(Map<Fruit, Integer> stock) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : stock.entrySet()) {
            stringBuilder.append(fruitIntegerEntry.getKey()
                                                  .getFruitName())
                         .append(SEPARATOR_CHAR)
                         .append(fruitIntegerEntry.getValue())
                         .append(NEW_LINE_CHAR);
        }
        Path path = Path.of(OUTPUT_FILE_NAME);
        try {
            Files.write(path, stringBuilder.toString()
                                           .getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.out.println(ERROR_MESSAGE + OUTPUT_FILE_NAME);
        }
    }
}
