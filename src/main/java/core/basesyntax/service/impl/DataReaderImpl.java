package core.basesyntax.service.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.DataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderImpl implements DataReader {
    @Override
    public List<FruitTransaction> readData(String filePart) throws IOException {

        List<FruitTransaction> transactions = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePart))) {
            String line;
            boolean firstLine = true;
            while ((line = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split("\\.");
                if (parts.length == 3) {
                    String operationCode = parts[0].trim();
                    String fruit = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());
                    FruitTransaction.Operation operation = FruitTransaction
                            .Operation.fromCode(operationCode);
                    if (operation != null) {
                        transactions.add(new FruitTransaction(operation, fruit, quantity));
                    }
                }
            }
        }
        return transactions;
    }
}
