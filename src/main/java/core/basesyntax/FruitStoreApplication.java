package core.basesyntax;

import static core.basesyntax.FruitStorage.fruits;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FruitStoreApplication {
    public void makeReport(String file) throws IOException {
        List<Transaction> transactions = FruitFileReader.fileReading(file);
        Map<Character, FruitOperation> operation = OperationType.operationMap;
        try {
            for (Transaction tr : transactions) {
                Fruit fruit = new Fruit();
                fruit.setFruitName(tr.getFruitName());
                fruit.setLocalDate(tr.getTransactionDate());
                for (int i = 0; i < tr.getQuantity(); i++) {
                    operation.get(tr.getOperation()).apply(fruit);
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("incorrect data in file", e);
        }
        FruitFileWriter.fileCompile(fruits);
    }
}
