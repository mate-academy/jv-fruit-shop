package core.basesyntax;

import static core.basesyntax.Storage.fruits;

import core.basesyntax.daily.Fruit;
import core.basesyntax.daily.Transaction;
import core.basesyntax.filesworking.FileReader;
import core.basesyntax.filesworking.ReportWriter;
import core.basesyntax.service.impl.StockChangeable;
import core.basesyntax.service.impl.TypeMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitStoreApplication {
    public static void main(String[] args) throws IOException {
        Storage storage = new Storage();
        String file = "File2.csv";
        makeReport(file);
    }

    public static void makeReport(String file) throws IOException {

        List<Transaction> transactions = new ArrayList<>();
        transactions = FileReader.fileReading(file);

        Map<Character, StockChangeable> stockChangeableMap = TypeMap.typeMap;
        try {
            for (Transaction tr : transactions) {
                Fruit fruit = new Fruit();
                fruit.setFruit(tr.getFruitType());
                fruit.setLocalDate(tr.getTransactionDate());
                for (int i = 0; i < tr.getQuantity(); i++) {
                    stockChangeableMap.get(tr.getOperation()).apply(fruit);
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("incorrect data in file");
        }
        ReportWriter.fileCompile(fruits);
    }
}
