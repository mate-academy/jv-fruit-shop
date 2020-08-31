package core.basesyntax;

import core.basesyntax.fileservice.FileReader;
import core.basesyntax.fileservice.FileWriter;
import core.basesyntax.fileservice.TransactionParser;
import core.basesyntax.fruitservice.FruitStorage;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader readFile = new FileReader();
        TransactionParser parser = new TransactionParser();
        FileWriter writer = new FileWriter();
        FruitStorage fruitStorage = new FruitStorage();
        OperationStrategy operationStrategy = new OperationStrategy();
        Map<String, Integer> fruitOutput = new HashMap<>();
        fruitStorage.getStorage().addAll(parser.parseDate(readFile.read("input.csv")));
        operationStrategy.operation(fruitOutput, fruitStorage.getStorage());
        writer.writeToFile(fruitOutput, "output.csv");
    }
}
