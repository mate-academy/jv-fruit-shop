package core.basesyntax;

import core.basesyntax.service.CsvReader;
import core.basesyntax.service.impl.CsvReaderImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvReader reader = new CsvReaderImpl();
        List<String> strings = reader.readLines("fruits.csv");
        strings.forEach(System.out::println);
        // Process data
        // Generate report based on data
        // Write report to new CSV file
    }
}
