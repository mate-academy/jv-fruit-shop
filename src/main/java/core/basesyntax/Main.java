package core.basesyntax;

import core.basesyntax.fileservice.ReadFile;
import core.basesyntax.fileservice.TransactionParser;
import core.basesyntax.fileservice.WriteToFile;
import core.basesyntax.fruitservice.FruitStorageService;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        TransactionParser parser = new TransactionParser();
        WriteToFile writer = new WriteToFile();
        FruitStorageService fruitStorageService = new FruitStorageService();
        OperationStrategy operationStrategy = new OperationStrategy();
        Map<String, Integer> fruitOutput = new HashMap<>();
        fruitStorageService.addAllToStorage(parser.parseDate(readFile.read("input.csv")));
        operationStrategy.operation(fruitOutput, fruitStorageService.getStorage());
        writer.writeToFile(fruitOutput, "output.csv");
    }
}
