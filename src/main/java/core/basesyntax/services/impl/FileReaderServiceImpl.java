package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
        return lines;
    }

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line: lines.subList(1, lines.size())) {
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new RuntimeException("Invalid line (must be split into 3 parts): " + line);
            }
            FruitTransaction.Operation operation;
            try {
                operation = FruitTransaction.Operation.valueOf(parts[0].toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Incorrect operation: " + parts[0] + " in line: "
                        + line, e);
            }
            String fruit = parts[1];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2]);
                if (quantity < 0) {
                    throw new RuntimeException("The quantity cannot be negative: "
                            + parts[2] + " in line: " + line);
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity (not number): "
                        + parts[2] + " in line: " + line, e);
            }
            transactions.add(new FruitTransaction(operation,fruit,quantity));
        }
        return transactions;
    }
}
