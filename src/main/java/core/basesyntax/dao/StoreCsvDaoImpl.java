package core.basesyntax.dao;

import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.entity.Operation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StoreCsvDaoImpl implements StoreCsvDao {

    private static final String PATH_TO_DAILY_ACTIVITY_FILE = "src/main/resources/dailyactivities.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/finalreport.csv";

    public StoreCsvDaoImpl() {
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        addColumnNames(PATH_TO_DAILY_ACTIVITY_FILE);
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append(fruitTransaction.getOperation().getCode());
        lineBuilder.append(",");
        lineBuilder.append(fruitTransaction.getFruit());
        lineBuilder.append(",");
        lineBuilder.append(fruitTransaction.getQuantity());
        lineBuilder.append(System.lineSeparator());
        String transactionLine = lineBuilder.toString();
        writeLinesToFile(transactionLine, PATH_TO_DAILY_ACTIVITY_FILE);
    }

    @Override
    public List<FruitTransaction> getAll() {
        List<String> allLines = readLines(PATH_TO_DAILY_ACTIVITY_FILE);
        return allLines.stream()
                .map(this::getTransactionFromCsv)
                .collect(Collectors.toList());
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
        writeLinesToFile(lines, PATH_TO_REPORT_FILE);
    }

    private List<String> readLines(String pathToFile) {
        List<String> lines = new ArrayList<>();
        File file = new File(pathToFile);
        try (InputStream inputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file" + pathToFile, e);
        }
        return lines;
    }


    private void addColumnNames(String pathToFile) {
        if (isEmptyFile(pathToFile)) {
            StringBuilder columnNamesBuilder = new StringBuilder();
            columnNamesBuilder.append("type,");
            columnNamesBuilder.append("fruit,");
            columnNamesBuilder.append("quantity");
            columnNamesBuilder.append(System.lineSeparator());
            String columnNames = columnNamesBuilder.toString();
            writeLinesToFile(columnNames, pathToFile);
            System.out.println("Columns was added successfully to file" + pathToFile);
        }
    }

    private boolean isEmptyFile(String pathToFile) {
        boolean isEmptyFile;
        try (InputStream inputStream = new FileInputStream(pathToFile);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(inputStreamReader)) {
            isEmptyFile = reader.readLine() == null;
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file" + pathToFile,e);
        }
        return isEmptyFile;
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

    private void writeLinesToFile(String lines, String pathToFile) {
        try (OutputStream outputStream = new FileOutputStream(pathToFile);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter writer = new BufferedWriter(outputStreamWriter)) {
            writer.write(lines);
            writer.flush();
            System.out.println("Report data was written successfully!");
        } catch (IOException e) {
            throw new RuntimeException("Cannot write the data to file :" + pathToFile, e);
        }
    }
}
