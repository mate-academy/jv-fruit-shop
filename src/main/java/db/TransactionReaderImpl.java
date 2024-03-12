package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class TransactionReaderImpl implements TransactionReader {
    @Override
    public List<FruitTransaction> readTransactionsFromFile(String fileName) {
        String receivedData = readFile(fileName);
        return Arrays.stream(receivedData.split("\n"))
                .map(str -> {
                    String[] parts = str.split(",");
                    return new FruitTransaction(convertToOperation(parts[0]),
                            parts[1],
                            Integer.valueOf(parts[2]));
                })
                .collect(Collectors.toList());
    }

    private String readFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.equals("type,fruit,quantity")) {
                    stringBuilder.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return stringBuilder.toString();
    }

    private FruitTransaction.Operation convertToOperation(String operationLetter) {
        return switch (operationLetter) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            default -> FruitTransaction.Operation.RETURN;
        };
    }
}
