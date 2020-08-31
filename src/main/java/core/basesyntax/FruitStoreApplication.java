package core.basesyntax;

import static core.basesyntax.daily.Storage.fruits;

import core.basesyntax.daily.Fruit;
import core.basesyntax.daily.Transaction;
import core.basesyntax.filesworking.FileReader;
import core.basesyntax.filesworking.ReportWriter;
import core.basesyntax.service.impl.StockChangeable;
import core.basesyntax.service.impl.TransactionTypeMap;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FruitStoreApplication {

    public void makeReport(String file) throws IOException {

        List<Transaction> transactions = FileReader.fileReading(file);

        Map<Character, StockChangeable> stockChangeableMap = TransactionTypeMap.typeMap;
        try {
            for (Transaction tr : transactions) {
                Fruit fruit = new Fruit();
                fruit.setFruitName(tr.getFruitName());
                fruit.setLocalDate(tr.getTransactionDate());
                for (int i = 0; i < tr.getQuantity(); i++) {
                    stockChangeableMap.get(tr.getOperation()).apply(fruit);
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("incorrect data in file", e);
        }
        ReportWriter.fileCompile(fruits);
    }
}
