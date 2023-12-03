package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader {
    public static List<FruitTransaction> readTransactions(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .skip(1) // Skip the header line
                    .map(line -> {
                        String[] parts = line.split(",");
                        return new FruitTransaction(
                                FruitTransaction.Operation.valueOf(parts[0].toUpperCase()),
                                parts[1],
                                Integer.parseInt(parts[2])
                        );
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading transactions from file", e);
        }
    }
}
