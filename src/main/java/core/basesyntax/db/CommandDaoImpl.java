package core.basesyntax.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.FruitStorage;
import model.FruitTransaction;
import model.FruitTransactionStorage;

public class CommandDaoImpl implements CommandDao {
    private static final String INPUT_FILE_NAME = "storage.csv";
    private static final String REPORT_FILE_NAME = "shop_report.csv";
    private static final String REPORT_FIRST_ROW = "fruit,quantity" + System.lineSeparator();
    private static final String SPLIT_REGEX = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransactionStorage read() {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(SPLIT_REGEX);
                FruitTransaction transaction = new FruitTransaction();
                transaction
                        .setOperation(FruitTransaction
                                .Operation.fromCode(parts[OPERATION_INDEX].trim()));
                transaction.setFruit(parts[FRUIT_INDEX]);
                transaction.setQuantity(Integer.parseInt(parts[QUANTITY_INDEX]));
                transactions.add(transaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read from file: " + INPUT_FILE_NAME, e);
        }

        return new FruitTransactionStorage(transactions);
    }

    @Override
    public void write(FruitStorage fruitInventory) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_FILE_NAME))) {
            writer.write(REPORT_FIRST_ROW);
            for (Map.Entry<String, Integer> entry : fruitInventory.getFruitInventory().entrySet()) {
                writer.write(entry.getKey() + SPLIT_REGEX
                        + entry.getValue()
                        + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + REPORT_FILE_NAME, e);
        }
    }
}
