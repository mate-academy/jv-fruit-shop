package core.basesyntax;

import core.basesyntax.fileservice.ReadFromFile;
import core.basesyntax.fileservice.WriteToFile;
import core.basesyntax.fruitservice.FruitStorage;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReadFromFile reader = new ReadFromFile();
        WriteToFile writer = new WriteToFile();
        FruitStorage fruitStorage = new FruitStorage();
        OperationStrategy operationStrategy = new OperationStrategy();
        Map<String, Integer> fruitOutput = new HashMap<>();
        reader.readFromFile("input.csv");
        operationStrategy.operation(fruitOutput, fruitStorage.getStorage());
        writer.writeToFile(fruitOutput, "output.csv");
    }
}
