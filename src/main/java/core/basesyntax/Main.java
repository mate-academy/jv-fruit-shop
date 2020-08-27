package core.basesyntax;

import core.basesyntax.fileservice.ReadFromFile;
import core.basesyntax.fileservice.WriteToFile;
import core.basesyntax.fruitservice.Transaction;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReadFromFile reader = new ReadFromFile();
        WriteToFile writer = new WriteToFile();
        OperationStrategy operationStrategy = new OperationStrategy();
        Map<String, Integer> fruitOutput = new HashMap<>();
        List<Transaction> transactions;
        transactions = reader.readFromFile("input.csv");
        operationStrategy.operation(fruitOutput, transactions);
        writer.writeToFile(fruitOutput, "output.csv");
    }
}
