package core.basesyntax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import core.basesyntax.model.FruitType;
import core.basesyntax.model.Transaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.SupplyOperation;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperation());
        map.put("p", new PurchaseOperation());
        map.put("s", new SupplyOperation());
        map.put("r", new SupplyOperation());

        OperationStrategy strategy = new OperationStrategy(map);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.csv"))) {
            bufferedReader.readLine();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Transaction transaction = new Transaction(data);
                if (strategy.contains(transaction.getOperation())) {
                    strategy.getByOperation(transaction.getOperation()).apply(transaction);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output-report.csv"))) {
            bufferedWriter.write("fruit,quantity\n");
            for (FruitType fruits : Storage.storage.keySet()) {
                bufferedWriter.write(fruits.toString().toLowerCase() + "," + Storage.storage.get(fruits));
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
