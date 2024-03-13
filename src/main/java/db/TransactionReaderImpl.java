package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class TransactionReaderImpl implements TransactionReader {
    private static final String TITLE = "type,fruit,quantity";
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final Map<String, FruitTransaction.Operation> operationConverterMap = Map.of(
            "b", FruitTransaction.Operation.BALANCE,
            "s", FruitTransaction.Operation.SUPPLY,
            "p", FruitTransaction.Operation.PURCHASE,
            "r", FruitTransaction.Operation.RETURN
    );

    @Override
    public List<FruitTransaction> readTransactionsFromFile(String fileName) {
        String receivedData = readFile(fileName);
        return Arrays.stream(receivedData.split(System.lineSeparator()))
                .map(str -> {
                    String[] parts = str.split(DATA_SEPARATOR);
                    return new FruitTransaction(operationConverterMap.get(parts[OPERATION]),
                            parts[FRUIT],
                            Integer.valueOf(parts[QUANTITY]));
                })
                .collect(Collectors.toList());
    }

    private String readFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals(TITLE)) {
                    stringBuilder.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return stringBuilder.toString();
    }
}
