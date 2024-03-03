package core.basesyntax.dao;

import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.entity.Operation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StoreCsvDaoImpl implements StoreCsvDao {

    private static final String PATH_TO_DAILY_ACTIVITY_FILE
            = "src/main/resources/dailyactivities.csv";
    private static final String PATH_TO_REPORT_FILE
            = "src/main/resources/finalreport.csv";

    private static final String FILE_IS_NULL_ERROR_MESSAGE
            = "The file that you try to read is null or does not exist";
    private static final String STRING_ARGUMENT_ERROR
            = "The string was passed in the argument is null";

    public StoreCsvDaoImpl() {
    }

    @Override
    public void addLine(FruitTransaction fruitTransaction) {
        addColumnNames();
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
        List<String> allLines = readLines();
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

    private List<String> readLines() {
        List<String> lines = new ArrayList<>();
        File file = new File(PATH_TO_DAILY_ACTIVITY_FILE);
        if (!file.exists()) {
            throw new RuntimeException(FILE_IS_NULL_ERROR_MESSAGE);
        }
        try (InputStream inputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(
                        inputStream, StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(inputStreamReader)) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file"
                    + PATH_TO_DAILY_ACTIVITY_FILE, e);
        }
        return lines;
    }

    private void addColumnNames() {
        if (isEmptyFile()) {
            StringBuilder columnNamesBuilder = new StringBuilder();
            columnNamesBuilder.append("type,");
            columnNamesBuilder.append("fruit,");
            columnNamesBuilder.append("quantity");
            columnNamesBuilder.append(System.lineSeparator());
            String columnNames = columnNamesBuilder.toString();
            writeLinesToFile(columnNames, StoreCsvDaoImpl.PATH_TO_DAILY_ACTIVITY_FILE);
            System.out.println("Columns was added successfully to file: "
                    + PATH_TO_DAILY_ACTIVITY_FILE);
        }
    }

    private boolean isEmptyFile() {
        boolean isEmptyFile;
        try (InputStream inputStream = new FileInputStream(PATH_TO_DAILY_ACTIVITY_FILE);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
                        StandardCharsets.UTF_8);
                BufferedReader reader = new BufferedReader(inputStreamReader)) {
            isEmptyFile = reader.readLine() == null;
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file" + PATH_TO_DAILY_ACTIVITY_FILE, e);
        }
        return isEmptyFile;
    }

    private FruitTransaction getTransactionFromCsv(String line) {
        Optional.ofNullable(line)
                .orElseThrow(() -> new IllegalArgumentException(STRING_ARGUMENT_ERROR));
        String[] row = line.split(",");
        Operation operation = Operation.chooseOperation(row[0]);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(row[1]);
        fruitTransaction.setQuantity(Integer.parseInt(row[2]));
        return fruitTransaction;
    }

    private void writeLinesToFile(String lines, String pathToFile) {
        Optional.ofNullable(lines)
                .orElseThrow(() -> new IllegalArgumentException(STRING_ARGUMENT_ERROR));
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
