package core.basesyntax.service.impl;

import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.StrategyStorage;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private String path;

    public CsvReader(String path) {
        this.path = path;
    }

    public List<FruitTransaction> readFromCsv(String pathToFile) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        try (BufferedReader br = Files
                .newBufferedReader(Path.of(pathToFile), StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                FruitTransaction fruitTransaction = createFruitTransaction(attributes);
                fruitTransactionList.add(fruitTransaction);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file" + path, e);
        }
        return fruitTransactionList;
    }

    private FruitTransaction createFruitTransaction(String[] metadata) {
        OperationStrategy operation = new StrategyStorage().getStrategy(metadata[0]);
        String name = metadata[1];
        int quantity = Integer.parseInt(metadata[2]);
        return new FruitTransaction(operation, name,quantity);
    }
}
