package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShopDaoImpl implements ShopDao {
    @Override
    public void readFromFile(String addressFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(addressFile))) {
            String line;
            boolean firstRowSkipped = false;
            while ((line = reader.readLine()) != null) {
                if (!firstRowSkipped) {
                    firstRowSkipped = true;
                    continue;
                }
                String[] row = line.split(",");
                String operationCode = row[0];
                String fruit = row[1];
                int quantity = Integer.parseInt(row[2]);
                FruitTransaction.Operation operation = getOperationFromCode(operationCode);
                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                Storage.getTransactions().add(transaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
    }

    private static FruitTransaction.Operation getOperationFromCode(String code) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new RuntimeException("Invalid operation code: " + code);
    }

    @Override
    public void writeToFile(HashMap<String, Integer> dataMap, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
                String fruit = entry.getKey();
                int quantity = entry.getValue();
                StringBuilder builder = new StringBuilder();
                builder.append(fruit)
                        .append(",")
                        .append(quantity)
                        .append("\n");
                writer.write(builder.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file ", e);
        }
    }

}
