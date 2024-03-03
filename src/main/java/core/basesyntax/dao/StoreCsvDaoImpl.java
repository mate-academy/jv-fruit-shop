package core.basesyntax.dao;

import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.entity.Operation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StoreCsvDaoImpl implements StoreCsvDao {

    private static final String PATH_TO_DAILY_ACTIVITY_FILE = "src/main/resources/dailyactivities.csv";

    private static final String PATH_TO_REPORT_FILE = "src/main/resources/finalreport.csv";

    public StoreCsvDaoImpl() {
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append("type,");
        lineBuilder.append("fruit,");
        lineBuilder.append("quantity");
        lineBuilder.append(System.lineSeparator());
        lineBuilder.append(fruitTransaction.getOperation().getCode());
        lineBuilder.append(",");
        lineBuilder.append(fruitTransaction.getFruit());
        lineBuilder.append(",");
        lineBuilder.append(fruitTransaction.getQuantity());
        lineBuilder.append(System.lineSeparator());
        String line = lineBuilder.toString();
        try {
            Files.writeString(Path.of(PathToFile.ACTIVITY_FILE_NAME), line);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write the data to file :" + PathToFile.ACTIVITY_FILE_NAME);
        }
    }

    @Override
    public List<FruitTransaction> getTransactionList(String operationCode) {
        List<String> allLines;
        try {
            allLines = Files.readAllLines(Path.of(PathToFile.ACTIVITY_FILE_NAME));

        } catch (IOException e) {
            throw new RuntimeException("Cannot read the data from csv " + PathToFile.ACTIVITY_FILE_NAME);
        }
        return allLines.stream()
                .filter(line -> line.startsWith(operationCode))
                .map(this::getTransactionFromCsv)
                .collect(Collectors.toList());
    }

    @Override
    public List<FruitTransaction> getAll() {
        List<String> allLines;
        File file = new File(PATH_TO_DAILY_ACTIVITY_FILE);
        try (InputStream inputStream = new FileInputStream(file)) {
            allLines = readLines(inputStream);
            return allLines.stream()
                    .map(this::getTransactionFromCsv)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Cannot open file: " + PATH_TO_DAILY_ACTIVITY_FILE, e);
        }
    }

    @Override
    public void saveReportToFile(Map<String, Integer> report) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append("fruit,");
        lineBuilder.append("quantity");
        lineBuilder.append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            lineBuilder.append(entry.getKey());
            lineBuilder.append(",");
            lineBuilder.append(entry.getValue());
            lineBuilder.append(System.lineSeparator());
        }
        String lines = lineBuilder.toString();
        writeLinesToFile(lines);
    }

    private static List<String> readLines(InputStream inputStream) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file", e);
        }
        return lines;
    }

    private FruitTransaction getTransactionFromCsv(String line) {
        String[] row = line.split(",");
        Operation operation = Operation.chooseOperation(row[0]);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(row[1]);
        fruitTransaction.setQuantity(Integer.parseInt(row[2]));
        return fruitTransaction;
    }

    private void writeLinesToFile(String lines) {
        try (OutputStream outputStream = new FileOutputStream(PATH_TO_REPORT_FILE);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter writer = new BufferedWriter(outputStreamWriter)) {
            writer.write(lines);
            writer.flush();
            System.out.println("Report data was written successfully!");
        } catch (IOException e) {
            throw new RuntimeException("Cannot write the data to file :" + PATH_TO_REPORT_FILE, e);
        }
    }
}

