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

public class FruitTransactionDaoCsvImpl implements FruitTransactionDao {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    private static final String TYPE_COLUMN = "type,";

    private static final String FRUIT_COLUMN = "fruit,";
    private static final String QUANTITY_COLUMN = "quantity";
    private static final String CANNOT_READ_FILE_MESSAGE = "Cannot read the file: ";
    private static final String CANNOT_WRITE_FILE_MESSAGE = "Cannot write the data to file: ";
    private static final String PATH_TO_DAILY_ACTIVITY_FILE
            = "src/main/resources/dailyactivities.csv";
    private static final String PATH_TO_REPORT_FILE
            = "src/main/resources/finalreport.csv";

    private static final String FILE_IS_NULL_ERROR_MESSAGE
            = "The file that you try to read is null or does not exist";
    private static final String STRING_ARGUMENT_ERROR
            = "The string was passed in the argument is null";

    @Override
    public void addTransaction(FruitTransaction fruitTransaction) {
        addColumnNames();
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append(fruitTransaction.getOperation().getCode());
        lineBuilder.append(SEPARATOR);
        lineBuilder.append(fruitTransaction.getFruit());
        lineBuilder.append(SEPARATOR);
        lineBuilder.append(fruitTransaction.getQuantity());
        lineBuilder.append(System.lineSeparator());
        String transactionLine = lineBuilder.toString();
        writeLinesToFile(transactionLine, PATH_TO_DAILY_ACTIVITY_FILE);
    }

    @Override
    public List<FruitTransaction> getAllTransactions() {
        List<String> allLines = readLines();
        return allLines.stream()
                .map(this::getTransactionFromCsv)
                .collect(Collectors.toList());
    }

    @Override
    public void fetchTransactionSummaryData(Map<String, Integer> summaryData) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append(FRUIT_COLUMN);
        lineBuilder.append(QUANTITY_COLUMN);
        lineBuilder.append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : summaryData.entrySet()) {
            lineBuilder.append(entry.getKey());
            lineBuilder.append(SEPARATOR);
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
            throw new RuntimeException(CANNOT_READ_FILE_MESSAGE
                    + PATH_TO_DAILY_ACTIVITY_FILE, e);
        }
        return lines;
    }

    private void addColumnNames() {
        if (isEmptyFile()) {
            StringBuilder columnNamesBuilder = new StringBuilder();
            columnNamesBuilder.append(TYPE_COLUMN);
            columnNamesBuilder.append(FRUIT_COLUMN);
            columnNamesBuilder.append(QUANTITY_COLUMN);
            columnNamesBuilder.append(System.lineSeparator());
            String columnNames = columnNamesBuilder.toString();
            writeLinesToFile(columnNames, FruitTransactionDaoCsvImpl.PATH_TO_DAILY_ACTIVITY_FILE);
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
            throw new RuntimeException(CANNOT_READ_FILE_MESSAGE + PATH_TO_DAILY_ACTIVITY_FILE, e);
        }
        return isEmptyFile;
    }

    private FruitTransaction getTransactionFromCsv(String line) {
        Optional.ofNullable(line)
                .orElseThrow(() -> new IllegalArgumentException(STRING_ARGUMENT_ERROR));
        String[] row = line.split(SEPARATOR);
        Operation operation = Operation.chooseOperation(row[OPERATION_INDEX]);
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(row[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(row[QUANTITY_INDEX]));
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
        } catch (IOException e) {
            throw new RuntimeException(CANNOT_WRITE_FILE_MESSAGE + pathToFile, e);
        }
    }
}
