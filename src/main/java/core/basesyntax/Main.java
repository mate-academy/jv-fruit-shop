package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.Mapper;
import core.basesyntax.service.impl.CsvReaderImpl;
import core.basesyntax.service.impl.FruitTransactionMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvReader reader = new CsvReaderImpl();
        List<String> strings = reader.readLines("fruits.csv");

        Mapper<FruitTransaction> mapper = new FruitTransactionMapper();
        List<FruitTransaction> transactions = strings.stream()
                .map(mapper::stringToObject)
                .toList();
        transactions.forEach(System.out::println);
        // Process data
        // Generate report based on data
        // Write report to new CSV file
    }
}
