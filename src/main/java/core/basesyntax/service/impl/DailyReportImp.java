package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DailyReportImp implements DailyReport {
    private static final String FILE_REPORT = "C:\\Users\\IdeaProjects\\jv-fruit-shop"
            + "\\src\\main\\java\\core\\basesyntax\\db\\report.csv";
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private final FruitDao fruitDao;

    public DailyReportImp(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String> report() {
        List<String> csvData = fruitDao.getCsv();

        Map<String, Integer> resultMap = csvData.stream()
                .map(s -> s.split(SEPARATOR))
                .collect(Collectors.groupingBy(
                        stringRow -> stringRow[FRUIT],
                        Collectors.summingInt(stringRow -> {
                            int quantity = Integer.parseInt(stringRow[QUANTITY]);
                            return "p".equals(stringRow[OPERATION]) ? -quantity : quantity;
                        })
                ));

        List<String> newCsvData = resultMap.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.toList());
        try (FileWriter fileWriter = new FileWriter(FILE_REPORT)) {

            fileWriter.append("fruit,quantity").append(System.lineSeparator());

            for (String transaction : newCsvData) {
                fileWriter.append(transaction).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create new CSV file " + FILE_REPORT, e);
        }
        return newCsvData;
    }
}
