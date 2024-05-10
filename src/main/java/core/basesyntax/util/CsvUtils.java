package core.basesyntax.util;

import static core.basesyntax.transactions.FruitsTransaction.Operation;

import core.basesyntax.transactions.FruitsTransaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
    private static final String COMMA_DELIMETER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public static List<FruitsTransaction> readTransactions(Path path) {
        List<FruitsTransaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] tokens = line.split(COMMA_DELIMETER);
                if (tokens.length < 3) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }

                try {
                    String o = tokens[OPERATION_INDEX].trim();
                    Operation operation = Operation.fromCode(o);
                    String fruit = tokens[FRUIT_INDEX].trim();
                    int quantity = Integer.parseInt(tokens[QUANTITY_INDEX].trim());
                    transactions.add(new FruitsTransaction(operation, fruit, quantity));
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid data format in line: "
                            + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + path + " - " + e.getMessage());
        }
        return transactions;
    }

    public static void writeReport(Path path, String report) {
        try (FileWriter writer = new FileWriter(path.toFile())) {
            writer.write(report);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + path + " - " + e.getMessage());
        }
    }
}
