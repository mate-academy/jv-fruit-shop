package core.basesyntax.service;

import core.basesyntax.dao.InputFileDao;
import core.basesyntax.model.InputData;
import core.basesyntax.strategy.ActivityStrategy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreServiceImpl implements StoreService {
    private static final String CSV_SEPARATOR = ",";
    private static final String TITLE_LINE_OF_REPORT_FILE = "fruit,quantity";
    private static final String IDENTIFIER = "quantity";
    private InputFileDao inputFileDao;
    private ActivityStrategy activityStrategy;

    public StoreServiceImpl(InputFileDao inputFileDao, ActivityStrategy activityStrategy) {
        this.inputFileDao = inputFileDao;
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void createReportFile(String reportFilePath, String inputFileName) {
        File file = new File(reportFilePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            StringBuilder builder = new StringBuilder(TITLE_LINE_OF_REPORT_FILE);
            for (String fruit : fruitQuantity(inputFileName)) {
                builder.append(System.lineSeparator()).append(fruit);
            }
            bufferedWriter.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }

    private List<String> fruitQuantity(String inputFileName) {
        InputData inputData = inputFileDao.getFromStorage(inputFileName);
        List<String> fruitNameAndQuantity = new ArrayList<>();
        for (String fruit : fruitNamesList(inputFileName)) {
            int total = inputData.getParsedFile().stream()
                    .filter(s -> s.contains(fruit))
                    .mapToInt(value -> activityStrategy.get(value).getNegativePositive()
                            * Integer.parseInt(value.substring(value.lastIndexOf(CSV_SEPARATOR)
                            + 1)))
                    .sum();
            fruitNameAndQuantity.add(fruit + CSV_SEPARATOR + total);
        }
        return fruitNameAndQuantity;
    }

    private List<String> fruitNamesList(String inputFileName) {
        InputData inputData = inputFileDao.getFromStorage(inputFileName);
        return inputData.getParsedFile().stream()
                .filter(s -> !s.contains(IDENTIFIER))
                .map(s -> s.substring(s.indexOf(CSV_SEPARATOR) + 1, s.lastIndexOf(CSV_SEPARATOR)))
                .distinct()
                .collect(Collectors.toList());
    }
}
