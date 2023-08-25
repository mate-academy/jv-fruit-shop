package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadService {
    public static List<FruitTransaction> readTransactions(String filePath) throws IOException {
        List<FruitTransaction> transactions = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                FruitTransaction.Operation operation = FruitTransaction.Operation.valueOf(parts[0]);
                String fruit = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                FruitTransaction transaction = new FruitTransaction();
                transaction.setOperation(operation);
                transaction.setFruit(fruit);
                transaction.setQuantity(quantity);
                transactions.add(transaction);
            }
        }

        reader.close();
        return transactions;
    }
}
